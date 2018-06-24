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
@Table(name="ENGINEER")

public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @NotNull
    @Column(name="FK_TEAM_ID")
    private Long fk_team_id;

    @NotNull
    @Size(min = 1, max = 150)
    @Column(name="NAME")
    private String name;

    @Size(min = 1, max = 150)
    @Column(name="EMAIL")
    private String email;

}
