package br.com.unirriter.bobsin.pdaaalert.controller;

import br.com.unirriter.bobsin.pdaaalert.domain.Engineer;
import br.com.unirriter.bobsin.pdaaalert.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/engineers")
public class EngineerController {

    @Autowired
    private EngineerService engineerService;

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<?> save(@RequestBody Engineer engineer) {
        engineerService.save(engineer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long engineerId) {
        engineerService.delete(engineerId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listAll")
    public ResponseEntity<List<Engineer>> list() {
        return new ResponseEntity<>(engineerService.listAll(), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/findById/{id}")
    public ResponseEntity<Engineer> findByEngineerId(@PathVariable Long engineerId) {
        Engineer engineer = engineerService.findByEngineerId(engineerId);
        if (engineer != null) {
            return new ResponseEntity(engineer, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/findByName/{name}")
    public ResponseEntity<Engineer> findByEngineerName(@PathVariable String engineerName) {
        Engineer engineer = engineerService.findByEngineerName(engineerName);
        if (engineer != null) {
            return new ResponseEntity(engineer, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/findByTeamId/{id}")
    public ResponseEntity<Engineer> findByTeamId(@PathVariable Long teamId) {
        List<Engineer> engineer = engineerService.findByTeamId(teamId);
        if (engineer != null) {
            return new ResponseEntity(engineer, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/assignEngineerTeamId")
    public ResponseEntity assignEngineerTeamId(@PathVariable Long engineerId, Long teamId) {
        Engineer engineer = engineerService.assignEngineerTeamId(engineerId, teamId);
        if (engineer != null) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}