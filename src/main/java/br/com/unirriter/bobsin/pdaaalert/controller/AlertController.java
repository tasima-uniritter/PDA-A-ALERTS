package br.com.unirriter.bobsin.pdaaalert.controller;

import br.com.unirriter.bobsin.pdaaalert.service.AlertService;
import br.com.unirriter.bobsin.pdaaalert.dto.MetricDTO;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/alerts")
public class AlertController {

    @Autowired
    SimpleEmailController email;
    
	private AlertService alertService;

    @RequestMapping(method = RequestMethod.POST, value = "/sendAlert")
    public ResponseEntity<MetricDTO> sendAlertFromMonitor(MetricDTO metricDTO) {
        ResponseEntity<MetricDTO> response;
        try {
            alertService.sendAlertFromMonitor(metricDTO);
            
            //TODO remover
            email.home();

            response = new ResponseEntity<>(metricDTO, HttpStatus.OK);

        } catch (Exception e) {
            response = new ResponseEntity<>(metricDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
