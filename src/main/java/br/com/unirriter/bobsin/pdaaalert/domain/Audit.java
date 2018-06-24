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
@Table(name="TEAM")

public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name="METRIC")
    private String metric;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name="TEAM")
    private String team;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name="ENGINEER")
    private String engineer;

    @NotNull
    @Column(name="TRIGGER_TIME")
    private Long trigger_time;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name="STATUS")
    private String status;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name="MESSAGE")
    private String message;
}
