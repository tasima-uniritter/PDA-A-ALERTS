package br.com.unirriter.bobsin.pdaaalert.controller;

import br.com.unirriter.bobsin.pdaaalert.domain.Audit;
import br.com.unirriter.bobsin.pdaaalert.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private AuditService auditService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<List<Audit>> list() {
        return new ResponseEntity<>(auditService.listAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        auditService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}