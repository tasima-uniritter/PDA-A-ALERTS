package br.com.unirriter.bobsin.pdaaalert.controller;

import br.com.unirriter.bobsin.pdaaalert.domain.Schedule;
import br.com.unirriter.bobsin.pdaaalert.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<List<Schedule>> list() {
        return new ResponseEntity<>(scheduleService.listAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<?> create(@RequestBody Schedule schedule) {
        scheduleService.create(schedule);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        scheduleService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}