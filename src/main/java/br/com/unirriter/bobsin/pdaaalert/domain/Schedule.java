package br.com.unirriter.bobsin.pdaaalert.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="AGENDA")

public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @NotNull
    @Column(name="FK_ENGINEER_ID")
    private Long fk_engineer_id;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name="WEEK_DAY")
    private String week_day;

    @Column(name="START_TIME")
    private Long start_time;

    @Column(name="END_TIME")
    private Long end_time;

}
