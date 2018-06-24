package br.com.unirriter.bobsin.pdaaalert.controller;

import br.com.unirriter.bobsin.pdaaalert.domain.Metric;
import br.com.unirriter.bobsin.pdaaalert.service.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/metric")
public class MetricController {

    @Autowired
    private MetricService metricService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<List<Metric>> list() {
        return new ResponseEntity<>(metricService.listAll(), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/find/{name}")
    public ResponseEntity<Metric> findByName(@PathVariable String name) {
        Metric metric = metricService.findByName(name);
        if (metric != null) {
            return new ResponseEntity(metric, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public ResponseEntity<Metric> findById(@PathVariable long id) {
        Metric metric = metricService.findByCode(id);
        if (metric != null) {
            return new ResponseEntity(metric, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<?> create(@Validated @RequestBody Metric metric) {
        metricService.create(metric);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        metricService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}