package br.com.unirriter.bobsin.pdaaalert.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="METRIC")

public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="METRIC_CODE")
    private Long code;

    @NotNull
    @Column(name="NAME", unique = true)
    private String name;

    @NotNull
    @Column(name="VALUE")
    private String value;
}
