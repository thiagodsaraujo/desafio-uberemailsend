package com.emailserviceuber.adapters;

public interface EmailSenderGateway {

    // interface igual, mas a diferença é que aqui é um contrato para a implementação do envio de email externo
    // poderia ser definido de forma diferente

    // vai ver qual classe está chamando e vai chamar o método correto para enviar o email

    void sendEmail(String to, String subject, String body);


}
