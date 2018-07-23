package br.com.unirriter.bobsin.pdaaalert.repository;

import br.com.unirriter.bobsin.pdaaalert.domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AuditRepository extends JpaRepository<Audit, Long> {
    List<Audit> findByMetricId(Long metricId);
    List<Audit> findByEngineerId(Long engineerId);
}