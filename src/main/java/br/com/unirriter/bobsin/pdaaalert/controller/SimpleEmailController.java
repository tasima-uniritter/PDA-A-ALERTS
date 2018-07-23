package br.com.unirriter.bobsin.pdaaalert.controller;

import javax.mail.internet.MimeMessage;

import br.com.unirriter.bobsin.pdaaalert.dto.MetricDTO;
import br.com.unirriter.bobsin.pdaaalert.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SimpleEmailController {

  @Autowired
  private JavaMailSender sender;


  @RequestMapping("/simpleemail")
  @ResponseBody
  String home() {
    try {
      sendEmail();
      return "Email Sent!";
    }catch(Exception ex) {
      return "Error in sending email: "+ex;
    }
  }

  private void sendEmail() throws Exception{
    MimeMessage message = sender.createMimeMessage();
    MimeMessageHelper helper = new MimeMessageHelper(message);

    helper.setTo("anderson.baum@gmail.com");
    helper.setText("How are you?");
    helper.setSubject("Hi");

    sender.send(message);
  }
}