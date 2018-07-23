package br.com.unirriter.bobsin.pdaaalert.controller;

import br.com.unirriter.bobsin.pdaaalert.service.AlertService;
import br.com.unirriter.bobsin.pdaaalert.dto.MetricDTO;
import lombok.AllArgsConstructor;
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

    private AlertService alertService;

    @RequestMapping(method = RequestMethod.POST, value = "/sendAlert")
    public ResponseEntity<MetricDTO> saveTeam(@RequestBody MetricDTO metricDTO) {
        ResponseEntity<MetricDTO> response;
        try {
            alertService.sendAlertFromMonitor(metricDTO);

            response = new ResponseEntity<>(metricDTO, HttpStatus.OK);

        } catch (Exception e) {
            response = new ResponseEntity<>(metricDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }
}
