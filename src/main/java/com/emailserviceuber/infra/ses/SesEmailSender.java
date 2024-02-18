package com.emailserviceuber.infra.ses;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import com.emailserviceuber.adapters.EmailSenderGateway;
import com.emailserviceuber.core.exceptions.EmailServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SesEmailSender implements EmailSenderGateway {

    // Essa classe implementa o contrato do gateway para envio de e-mails, e no caso é o SES
    // tudo automatico


    @Autowired
    private AmazonSimpleEmailService amazonSimpleEmailService;

//    //com ou sem injeção de dependência
//    @Autowired
//    public SesEmailSender(AmazonSimpleEmailService amazonSimpleEmailService) {
//        this.amazonSimpleEmailService = amazonSimpleEmailService;
//    }

    @Override
    public void sendEmail(String to, String subject, String body) {
        // implementação do envio de email com o SES

        SendEmailRequest request = new SendEmailRequest()
                .withSource("thiagodsaraujo@gmail.com")
                .withDestination(new Destination().withToAddresses("thiagoaraujoadvg@gmail.com"))
                .withMessage(new Message()
                        .withSubject(new Content(subject))
                        .withBody(new Body().withText(new Content(body))));

        try {

            this.amazonSimpleEmailService.sendEmail(request);

        } catch (AmazonServiceException e) {
            System.out.println(e.getErrorMessage());
            throw new EmailServiceException("Failure while send email with SES", e);
        }
    }
}
