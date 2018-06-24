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
@Table(name="METRIC")

public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="CODE")
    private Long code;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name="NAME")
    private String name;

    @Size(min = 1, max = 300)
    @Column(name="SPEC")
    private String spec;
}
