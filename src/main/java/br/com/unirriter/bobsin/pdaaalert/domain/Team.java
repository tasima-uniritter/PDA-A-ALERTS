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

    @ManyToOne
    @JoinColumn(name = "METRIC_CODE", unique = true)
    @JsonSerialize(using = MetricSerializer.class)
    private Metric metricCode;

    @Column(name="NAME", unique = true)
    private String name;

    @Column(name="DESCRIPTION")
    private String description;

    @JsonBackReference
    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "teamId")
    private List<Engineer> engineer;
}