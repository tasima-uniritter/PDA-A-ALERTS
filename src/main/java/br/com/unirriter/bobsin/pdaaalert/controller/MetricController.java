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
@RequestMapping("/metrics")
public class MetricController {

    @Autowired
    private MetricService metricService;

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity<?> save(@Validated @RequestBody Metric metric) {
        metricService.save(metric);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long metricId) {
        metricService.delete(metricId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listAll")
    public ResponseEntity<List<Metric>> list() {
        return new ResponseEntity<>(metricService.listAll(), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/findByName/{name}")
    public ResponseEntity<Metric> findByMetricName(@PathVariable String metricName) {
        Metric metric = metricService.findByMetricName(metricName);
        if (metric != null) {
            return new ResponseEntity(metric, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/findById/{id}")
    public ResponseEntity<Metric> findByMetricId(@PathVariable Long metricId) {
        Metric metric = metricService.findByMetricId(metricId);
        if (metric != null) {
            return new ResponseEntity(metric, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}