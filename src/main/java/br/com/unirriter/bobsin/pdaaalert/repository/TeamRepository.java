package br.com.unirriter.bobsin.pdaaalert.repository;

import br.com.unirriter.bobsin.pdaaalert.domain.Metric;
import br.com.unirriter.bobsin.pdaaalert.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByTeamName(String name);
    Team findByTeamMetricId(Long metricId);
    Team findByTeamMetricName(String metricName);
}