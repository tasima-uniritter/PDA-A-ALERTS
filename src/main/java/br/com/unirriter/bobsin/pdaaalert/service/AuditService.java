package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Audit;
import br.com.unirriter.bobsin.pdaaalert.domain.Engineer;
import br.com.unirriter.bobsin.pdaaalert.dto.MetricDTO;
import br.com.unirriter.bobsin.pdaaalert.enums.NotificationStatus;
import br.com.unirriter.bobsin.pdaaalert.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional

public class AuditService {
    @Autowired
    private AuditRepository auditRepository;

    public void save(Engineer engineer, MetricDTO metricContent, NotificationStatus success, String message) {
        Audit audit = new Audit();
        audit.setEngineer(engineer);
        audit.setMetricContent(metricContent.toString());
        audit.setStatus(success);
        audit.setTriggerTimestamp(LocalDateTime.now());
        audit.setMessage(message);

        this.auditRepository.save(audit);
    }

    public List<Audit> listAll() {
        return auditRepository.findAll();
    }

    public void delete(Long id) {
        auditRepository.deleteById(id);
    }

}