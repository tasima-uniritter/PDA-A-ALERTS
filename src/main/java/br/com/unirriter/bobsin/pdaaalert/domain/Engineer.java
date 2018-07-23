package br.com.unirriter.bobsin.pdaaalert.domain;

import br.com.unirriter.bobsin.pdaaalert.serializer.TeamSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/*
  Um Engineer é uma pessoa que está vinculda a um Team e está escalado em algum horário de trabalho.
  Ele está associado a apenas um Team (1) e podem estar em diversas escalas Schedule (n).
*/

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "ENGINEER")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ENGINEER_ID")
    private Long engineerId;

    @NotNull
    @Column(name="ENGINEER_NAME", unique = true)
    private String engineerName;

    @NotNull
    @Column(name="ENGINEER_EMAIL", unique = true)
    private String engineerEmail;

    @ManyToOne
    @JsonSerialize(using = TeamSerializer.class)
    @JoinColumn(name = "TEAM_ID")
    private Team teamId;

    @JsonBackReference
    @OneToMany(mappedBy = "engineerId", cascade = CascadeType.ALL)
    private List<Schedule> engineerSchedule;
}