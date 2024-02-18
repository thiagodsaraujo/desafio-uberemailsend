package com.emailserviceuber.core;

public interface EmailSenderUserCase {



    // caso de uso principal da aplicação, regras de negócio

    void sendEmail(String to, String subject, String body);

}
