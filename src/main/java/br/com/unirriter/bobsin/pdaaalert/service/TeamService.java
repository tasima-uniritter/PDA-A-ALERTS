package br.com.unirriter.bobsin.pdaaalert.service;

import br.com.unirriter.bobsin.pdaaalert.domain.Team;
import br.com.unirriter.bobsin.pdaaalert.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional

public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public Team save(Team team) {
        return this.teamRepository.save(team);
    }

    public void delete(Long teamId) {
        teamRepository.deleteById(teamId);
    }

    public List<Team> listAll() {
        return teamRepository.findAll();
    }

    public Team findByTeamId(Long teamId) throws EntityNotFoundException {
        return this.teamRepository.getOne(teamId);
    }

    public Team findByTeamName(String teamName) {
        return teamRepository.findByTeamName(teamName);
    }

    public Team findByTeamMetricId(Long metricId) {
        Team team = teamRepository.findByTeamMetricId(metricId);

        if (team == null) {
            throw new EntityNotFoundException("Cannot find a team responsible for metric \"" + metricId + "\"");
        }
        return team;
    }
}