package br.com.unirriter.bobsin.pdaaalert.domain;

import br.com.unirriter.bobsin.pdaaalert.serializer.MetricSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import javax.persistence.*;
import java.util.List;

/*
  Um Team é uma unidade de organização responsável por uma única Metric (ex.: Memória, CPU, Disco).
  Ele é composto por Engineer (n) e uma Metric (1).
*/

@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="TEAM")

public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="TEAM_ID")
    private Long teamId;

    @Column(name="TEAM_NAME", unique = true)
    private String teamName;

    @Column(name="TEAM_DESCRIPTION")
    private String teamDescription;

    @ManyToOne
    @JoinColumn(name = "METRIC_ID", unique = true)
    @JsonSerialize(using = MetricSerializer.class)
    private Metric teamMetricId;

    @JsonBackReference
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "teamId")
    private List<Engineer> engineer;
}