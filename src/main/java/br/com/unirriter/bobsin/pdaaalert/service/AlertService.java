package br.com.unirriter.bobsin.pdaaalert.service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import br.com.unirriter.bobsin.pdaaalert.domain.Engineer;
import br.com.unirriter.bobsin.pdaaalert.domain.Schedule;
import br.com.unirriter.bobsin.pdaaalert.domain.Team;
import br.com.unirriter.bobsin.pdaaalert.dto.MetricDTO;
import br.com.unirriter.bobsin.pdaaalert.enums.NotificationStatus;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AlertService {
    private TeamService teamService;
    @Autowired
    private JavaMailSender mailSender;
    private AuditService auditService;

    public void sendAlertFromMonitor(MetricDTO metricPayload) throws Exception {
        System.out.println("passei");
        try {
            LocalDateTime metricInstantDateTime = LocalDateTime.now();
            DayOfWeek metricInstantDayOfWeek = DayOfWeek.from(metricInstantDateTime);
            LocalTime metricInstantTime = LocalTime.from(metricInstantDateTime);

            boolean isEngineerOnCallAvailable = false;

            Team team = teamService.findByTeamMetricName(metricPayload.getMetric());

            for (Engineer engineer : team.getEngineer()) {
                List<Schedule> engineerSchedule = engineer.getEngineerSchedule();
                for (Schedule schedule : engineerSchedule) {
                    if (schedule.getScheduleWeekDay().equals(metricInstantDayOfWeek)) {
                        if (isEngineerOnCall(schedule, metricInstantTime)) {
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
        LocalTime startOnCall = dailySchedule.getScheduleStartTime();
        LocalTime endOnCall = dailySchedule.getScheduleEndTime();
        if (startOnCall.isAfter(endOnCall)) {
            return !metricInstantTime.isBefore(startOnCall) || !metricInstantTime.isAfter(endOnCall);
        } else {
            return !metricInstantTime.isBefore(startOnCall) && !metricInstantTime.isAfter(endOnCall);
        }
    }

}