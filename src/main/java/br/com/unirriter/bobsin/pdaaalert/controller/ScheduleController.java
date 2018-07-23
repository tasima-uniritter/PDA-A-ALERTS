package br.com.unirriter.bobsin.pdaaalert.controller;

import br.com.unirriter.bobsin.pdaaalert.domain.Schedule;
import br.com.unirriter.bobsin.pdaaalert.domain.Team;
import br.com.unirriter.bobsin.pdaaalert.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/schedules")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<?> save(@RequestBody Schedule schedule) {
        scheduleService.save(schedule);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listAll")
    public ResponseEntity<List<Schedule>> list() {
        return new ResponseEntity<>(scheduleService.listAll(), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/findById/{id}")
    public ResponseEntity<Team> findByScheduleId(@PathVariable Long scheduleId) {
        Schedule schedule = scheduleService.findByScheduleId(scheduleId);
        if (schedule != null) {
            return new ResponseEntity(schedule, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}