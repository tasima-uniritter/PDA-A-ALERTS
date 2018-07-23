package br.com.unirriter.bobsin.pdaaalert.controller;

import br.com.unirriter.bobsin.pdaaalert.domain.Team;
import br.com.unirriter.bobsin.pdaaalert.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<?> save(@RequestBody Team team) {
        teamService.save(team);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long teamId) {
        teamService.delete(teamId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listAll")
    public ResponseEntity<List<Team>> list() {
        return new ResponseEntity<>(teamService.listAll(), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/findById/{id}")
    public ResponseEntity<Team> findByTeamId(@PathVariable Long teamId) {
        Team team = teamService.findByTeamId(teamId);
        if (team != null) {
            return new ResponseEntity(team, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/findByName/{name}")
    public ResponseEntity<Team> findByTeamName(@PathVariable String teamName) {
        Team team = teamService.findByTeamName(teamName);
        if (team != null) {
            return new ResponseEntity(team, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/findByMetricId/{id}")
    public ResponseEntity<Team> findByTeamMetricId(@PathVariable Long metricId) {
        Team team = teamService.findByTeamMetricId(metricId);
        if (team != null) {
            return new ResponseEntity(team, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}