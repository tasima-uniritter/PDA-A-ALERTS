package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Audit;
import br.com.unirriter.bobsin.pdaaalert.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional

public class AuditService {
    @Autowired
    private AuditRepository auditRepository;

    public void create(Audit audit) {
        auditRepository.save(audit);
    }

    public List<Audit> listAll() {
        return auditRepository.findAll();
    }

    public void delete(Long id) {
        auditRepository.deleteById(id);
    }

}