package br.com.unirriter.bobsin.pdaaalert.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/*
  Uma Metric é uma unidade coletada de um computador (ex.: Memória, CPU, Disco).
  Ela é utilizada para determinar qual é o Team que deverá receber um alerta.
*/

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="METRIC")

public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="METRIC_ID")
    private Long metricId;

    @JsonBackReference
    @NotNull
    @Column(name="METRIC_NAME", unique = true)
    private String metricName;

    @OneToOne
    @JoinColumn(name = "METRIC_ID", referencedColumnName = "TEAM_ID")
    private Team teamId;
}
