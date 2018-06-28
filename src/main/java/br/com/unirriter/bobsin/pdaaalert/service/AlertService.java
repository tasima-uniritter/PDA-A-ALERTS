package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Engineer;
import br.com.unirriter.bobsin.pdaaalert.domain.Schedule;
import br.com.unirriter.bobsin.pdaaalert.domain.Team;
import br.com.unirriter.bobsin.pdaaalert.dto.MetricDTO;
import br.com.unirriter.bobsin.pdaaalert.enums.NotificationStatus;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
@AllArgsConstructor
public class AlertService {
    private TeamService teamService;
    @Autowired
    private JavaMailSender mailSender;
    private AuditService auditService;

    public void sendAlertFromMonitor(MetricDTO metricPayload) throws Exception {
        try {
            LocalDateTime metricInstantDateTime = LocalDateTime.now();
            DayOfWeek metricInstantDayOfWeek = DayOfWeek.from(metricInstantDateTime);
            LocalTime metricInstantTime = LocalTime.from(metricInstantDateTime);

            boolean isEngineerOnCallAvailable = false;

            Team team = teamService.getByMetricCode(metricPayload.getMetric());

            for (Engineer engineer : team.getEngineer()) {
                List<Schedule> engineerSchedule = engineer.getEngineerSchedule();
                for (Schedule schedule : engineerSchedule) {
                    if (schedule.getWeekDay().equals(metricInstantDayOfWeek)) {
                        if (isEngineerOnCall(schedule, metricInstantTime)) {
                            sendAlertEmail(metricPayload, engineer);
                            isEngineerOnCallAvailable = true;
                        }
                    }
                }
            }

            if (!isEngineerOnCallAvailable) {
                auditService.save(null, metricPayload, NotificationStatus.FAILURE, "No Engineers available at this moment!.");
            }

        } catch (Exception exception) {
            throw new Exception(exception.getMessage());
        }
    }

    private boolean isEngineerOnCall(Schedule dailySchedule, LocalTime metricInstantTime) {
        LocalTime startOnCall = dailySchedule.getStartTime();
        LocalTime endOnCall = dailySchedule.getEndTime();
        if (startOnCall.isAfter(endOnCall)) {
            return !metricInstantTime.isBefore(startOnCall) || !metricInstantTime.isAfter(endOnCall);
        } else {
            return !metricInstantTime.isBefore(startOnCall) && !metricInstantTime.isAfter(endOnCall);
        }
    }

    private void sendAlertEmail(MetricDTO metricContent, Engineer engineerOnCall) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();

            message.setSubject("[TDA-A-ALERT] Container " + metricContent.getOrigin() + " needs your attention!");
            message.setText("Dear Engineer \"" + engineerOnCall.getName() + "\" from Team \"" + engineerOnCall.getTeamId().getName() + "\" please check the following alert: \n\n" + metricContent.toString());
            message.setTo(engineerOnCall.getEmail());
            message.setFrom("anderson.baum@gmail.com");

            mailSender.send(message);

            auditService.save(engineerOnCall, metricContent, NotificationStatus.SUCCESS, "Email sent.");
        } catch (Exception exception) {
            auditService.save(engineerOnCall, metricContent, NotificationStatus.FAILURE, exception.getMessage());
        }
    }
}
