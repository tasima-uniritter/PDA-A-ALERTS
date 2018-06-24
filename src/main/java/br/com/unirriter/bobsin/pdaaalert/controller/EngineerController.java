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
@RequestMapping("/engineer")
public class EngineerController {

    @Autowired
    private EngineerService engineerService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<List<Engineer>> list() {
        return new ResponseEntity<>(engineerService.listAll(), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/find/{name}")
    public ResponseEntity<Engineer> findByName(@PathVariable String name) {
        Engineer engineer = engineerService.findByName(name);
        if (engineer != null) {
            return new ResponseEntity(engineer, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<?> create(@RequestBody Engineer engineer) {
        engineerService.create(engineer);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        engineerService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}