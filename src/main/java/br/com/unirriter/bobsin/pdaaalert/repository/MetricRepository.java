package br.com.unirriter.bobsin.pdaaalert.repository;

import br.com.unirriter.bobsin.pdaaalert.domain.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    Metric findByMetricId(Long metricId);
    Metric findByMetricName(String metricName);
}