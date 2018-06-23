package br.com.unirriter.bobsin.tdaalert.controller;

import br.com.unirriter.bobsin.tdaalert.domain.Metric;
import br.com.unirriter.bobsin.tdaalert.service.MetricService;
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

    @RequestMapping(method = RequestMethod.GET, value = "/listar")
    public ResponseEntity<List<Metric>> listar() {
        return new ResponseEntity<>(metricService.listarTodos(), HttpStatus.OK);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/buscar/{name}")
    public ResponseEntity<Metric> buscarPorName(@PathVariable String name) {
        Metric metric = metricService.buscarPorName(name);
        if (metric != null) {
            return new ResponseEntity(metric, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public ResponseEntity<Metric> buscarPorId(@PathVariable long id) {
        Metric metric = metricService.buscarPorId(id);
        if (metric != null) {
            return new ResponseEntity(metric, HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cadastrar")
    public ResponseEntity<?> cadastrar(@Validated @RequestBody Metric metric) {
        metricService.cadastrar(metric);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    /*@RequestMapping(method = RequestMethod.DELETE, value = "/deletar/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        metricService.deletar(id);
        return new ResponseEntity(HttpStatus.OK);
    }*/
}