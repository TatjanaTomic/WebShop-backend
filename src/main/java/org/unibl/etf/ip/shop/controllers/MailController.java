package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.models.entities.Mail;
import org.unibl.etf.ip.shop.services.impl.MailService;

@RestController
@RequestMapping("/api/v1/email")
@CrossOrigin(origins = "http://localhost:4200/")
public class MailController {

    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    public String insert(@RequestBody Mail mail) {
        return mailService.sendSimpleMail(mail);
    }
}
