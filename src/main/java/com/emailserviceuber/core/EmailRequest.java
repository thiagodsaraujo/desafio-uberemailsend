package com.emailserviceuber.core;

public record EmailRequest(String to, String subject, String body) {
}
