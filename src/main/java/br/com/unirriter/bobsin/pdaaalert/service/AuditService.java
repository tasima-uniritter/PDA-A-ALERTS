package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Audit;
import br.com.unirriter.bobsin.pdaaalert.domain.Engineer;
import br.com.unirriter.bobsin.pdaaalert.dto.MetricDTO;
import br.com.unirriter.bobsin.pdaaalert.enums.NotificationStatus;
import br.com.unirriter.bobsin.pdaaalert.repository.AuditRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
public class AuditService {
    private AuditRepository auditRepository;

    public Audit save(Engineer engineer, MetricDTO metricContent, NotificationStatus success, String message) {
        Audit audit = new Audit();
        audit.setAuditMetricContent(metricContent.toString());
        audit.setAuditTriggerTimestamp(LocalDateTime.now());
        audit.setAuditStatus(success);
        audit.setAuditMessage(message);
        audit.setEngineerId(engineer);

        this.auditRepository.save(audit);
        return audit;
    }

    public void delete(Long id) {
        auditRepository.deleteById(id);
    }

    public List<Audit> listAll() {
        return auditRepository.findAll();
    }

    public List<Audit> findByMetricId(Long metricId) {
        return auditRepository.findByMetricId(metricId);
    }

    public List<Audit> findByEngineerId(Long engineerId) {
        return auditRepository.findByEngineerId(engineerId);
    }
}