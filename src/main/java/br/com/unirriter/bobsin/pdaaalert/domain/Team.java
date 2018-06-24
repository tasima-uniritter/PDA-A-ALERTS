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

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @NotNull
    @Column(name="FK_METRIC_CODE")
    private Long fk_metric_code;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name="NAME")
    private String name;

    @Size(min = 1, max = 300)
    @Column(name="DESC")
    private String desc;

}
