package br.com.unirriter.bobsin.pdaaalert.repository;

import br.com.unirriter.bobsin.pdaaalert.domain.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRepository extends JpaRepository<Audit, Long> {

}