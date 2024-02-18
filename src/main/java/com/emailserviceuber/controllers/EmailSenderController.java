package com.emailserviceuber.controllers;

import com.emailserviceuber.application.EmailSenderService;
import com.emailserviceuber.core.EmailRequest;
import com.emailserviceuber.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/email")
public class EmailSenderController {


    @Autowired
    private EmailSenderService emailSenderService;


//    @Autowired
//    public EmailSenderController(EmailSenderService emailSenderService) {
//        this.emailSenderService = emailSenderService;
//    }


    @PostMapping()
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            this.emailSenderService.sendEmail(emailRequest.to(), emailRequest.subject(), emailRequest.body());
            return ResponseEntity.ok("Email send successfully!");

        } catch (EmailServiceException e) {
            return ResponseEntity.badRequest().body("Error while send email: " + e.getMessage());
        }
    }


}
