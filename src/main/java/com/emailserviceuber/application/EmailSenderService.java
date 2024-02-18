package com.emailserviceuber.application;


import com.emailserviceuber.adapters.EmailSenderGateway;
import com.emailserviceuber.core.EmailSenderUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService implements EmailSenderUserCase {

   // implementação do meu user case

    // Mas depende do gateway para enviar o email

    @Autowired
    private EmailSenderGateway emailSenderGateway;

//    @Autowired
//    public EmailSenderService(EmailSenderGateway emailSenderGateway) {
//        this.emailSenderGateway = emailSenderGateway;
//    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        this.emailSenderGateway.sendEmail(to, subject, body);
    }
}
