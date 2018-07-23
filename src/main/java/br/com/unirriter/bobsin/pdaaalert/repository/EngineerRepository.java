package br.com.unirriter.bobsin.pdaaalert.repository;

import br.com.unirriter.bobsin.pdaaalert.domain.Engineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EngineerRepository extends JpaRepository<Engineer, Long> {
    Engineer findByEngineerName(String engineerName);
    List<Engineer> findByTeamId(Long teamId);
}