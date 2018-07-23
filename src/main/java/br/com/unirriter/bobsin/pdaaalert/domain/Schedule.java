package br.com.unirriter.bobsin.pdaaalert.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;

/*
  Um Schedule é uma agenda contendo as escalas de trabalho dos Engineer.
  Ela é composta por Engenheiros (n).
*/

@Data
@AllArgsConstructor
@ToString(exclude = "engineerId")
@NoArgsConstructor
@Entity
@Table(name="SCHEDULE", uniqueConstraints = {
            @UniqueConstraint(columnNames = {"ENGINEER_ID", "SCHEDULE_WEEK_DAY", "SCHEDULE_START_TIME"}),
            @UniqueConstraint(columnNames = {"ENGINEER_ID", "SCHEDULE_WEEK_DAY", "SCHEDULE_END_TIME"}),
            @UniqueConstraint(columnNames = {"ENGINEER_ID", "SCHEDULE_WEEK_DAY", "SCHEDULE_START_TIME", "SCHEDULE_END_TIME"})
        }
        )

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SCHEDULE_ID")
    private Long scheduleId;

    @NotNull
    @Column(name="SCHEDULE_WEEK_DAY")
    @Enumerated(value = EnumType.STRING)
    private DayOfWeek scheduleWeekDay;

    @NotNull
    @Column(name="SCHEDULE_START_TIME")
    private LocalTime scheduleStartTime;

    @NotNull
    @Column(name="SCHEDULE_END_TIME")
    private LocalTime scheduleEndTime;

    @ManyToOne
    @JoinColumn(name = "ENGINEER_ID", referencedColumnName = "ENGINEER_ID")
    private Engineer engineerId;
}