package br.com.unirriter.bobsin.tdaalert.repository;

import br.com.unirriter.bobsin.tdaalert.domain.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    Metric findByCode(Long code);
    Metric findByName(String name);
}