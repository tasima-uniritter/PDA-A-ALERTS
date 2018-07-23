package br.com.unirriter.bobsin.pdaaalert.controller;

import br.com.unirriter.bobsin.pdaaalert.domain.Audit;
import br.com.unirriter.bobsin.pdaaalert.domain.Engineer;
import br.com.unirriter.bobsin.pdaaalert.dto.MetricDTO;
import br.com.unirriter.bobsin.pdaaalert.enums.NotificationStatus;
import br.com.unirriter.bobsin.pdaaalert.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/audits")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public ResponseEntity save(@PathVariable Engineer engineer, MetricDTO metricContent, NotificationStatus success, String message) {
        Audit audit = auditService.save(engineer, metricContent, success, message);
        if (engineer != null) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity(HttpStatus.FAILED_DEPENDENCY);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteById/{id}")
    public ResponseEntity<?> delete(@PathVariable Long auditId) {
        auditService.delete(auditId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listAll")
    public ResponseEntity<List<Audit>> list() {
        return new ResponseEntity<>(auditService.listAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByMetricId/{id}")
    public ResponseEntity<List<Audit>> findByMetricId(@PathVariable Long metricId) {
        List<Audit> auditList = auditService.findByMetricId(metricId);
        return new ResponseEntity<>(auditList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findByEngineerId/{id}")
    public ResponseEntity<List<Audit>> findByEngineerId(@PathVariable Long engineerId) {
        List<Audit> auditList = auditService.findByEngineerId(engineerId);
        return new ResponseEntity<>(auditList, HttpStatus.OK);
    }
}