package br.com.unirriter.bobsin.pdaaalert.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.DayOfWeek;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@ToString(exclude = "engineerId")
@NoArgsConstructor
@Entity
@Table(name="SCHEDULE",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"ENGINEER_ID", "WEEK_DAY", "START_TIME"}),
            @UniqueConstraint(columnNames = {"ENGINEER_ID", "WEEK_DAY", "END_TIME"}),
            @UniqueConstraint(columnNames = {"ENGINEER_ID", "WEEK_DAY", "START_TIME", "END_TIME"})
        }
        )

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="SCHEDULE_ID")
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "ENGINEER_ID", referencedColumnName = "ENGINEER_ID")
    private Engineer engineerId;

    @NotNull
    @Column(name="WEEK_DAY")
    @Enumerated(value = EnumType.STRING)
    private DayOfWeek weekDay;

    @NotNull
    @Column(name="START_TIME")
    private LocalTime startTime;

    @NotNull
    @Column(name="END_TIME")
    private LocalTime endTime;

}