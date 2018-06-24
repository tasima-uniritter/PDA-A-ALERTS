package br.com.unirriter.bobsin.pdaaalert.repository;

import br.com.unirriter.bobsin.pdaaalert.domain.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Team findByName(String name);
}