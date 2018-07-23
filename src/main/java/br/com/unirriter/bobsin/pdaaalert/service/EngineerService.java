package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Engineer;
import br.com.unirriter.bobsin.pdaaalert.domain.Team;
import br.com.unirriter.bobsin.pdaaalert.repository.EngineerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Component
@AllArgsConstructor
public class EngineerService {

    private final EngineerRepository engineerRepository;
    private final TeamService teamService;

    public Engineer save(Engineer engineer) {
        return this.engineerRepository.save(engineer);
    }

    public void delete(Long engineerId) {
        engineerRepository.deleteById(engineerId);
    }

    public List<Engineer> listAll() {
        return engineerRepository.findAll();
    }

    public Engineer findByEngineerId(Long engineerId) throws EntityNotFoundException {
        return this.engineerRepository.getOne(engineerId);
    }

    public Engineer findByEngineerName(String engineerName) {
        return engineerRepository.findByEngineerName(engineerName);
    }

    public List<Engineer> findByTeamId(Long teamId) {
        return this.engineerRepository.findByTeamId(teamId);
    }

    public Engineer assignEngineerTeamId(Long engineerId, Long teamId) {
        Engineer engineerAssignedToTeam;
        try {
            Engineer engineer = findByEngineerId(engineerId);
            Team team = teamService.findByTeamId(teamId);

            engineer.setTeamId(team);
            engineerAssignedToTeam = save(engineer);

        } catch (EntityNotFoundException exception) {
            throw new EntityNotFoundException(exception.getMessage());
        }
        return engineerAssignedToTeam;
    }
}