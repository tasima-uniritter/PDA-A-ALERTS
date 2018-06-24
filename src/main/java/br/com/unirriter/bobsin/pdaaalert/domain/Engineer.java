package br.com.unirriter.bobsin.pdaaalert.domain;

import br.com.unirriter.bobsin.pdaaalert.serializer.TeamSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@Entity
@Table(name="ENGINEER")

public class Engineer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ENGINEER_ID")
    private Long engineerId;

    @ManyToOne
    @JsonSerialize(using = TeamSerializer.class)
    @JoinColumn(name = "TEAM_ID")
    private Team teamId;

    @NotNull
    @Column(name="NAME", unique = true)
    private String name;

    @NotNull
    @Column(name="EMAIL", unique = true)
    private String email;

    @JsonBackReference
    @OneToMany(mappedBy = "engineerId", cascade = CascadeType.ALL)
    private List<Schedule> engineerSchedule;

}
