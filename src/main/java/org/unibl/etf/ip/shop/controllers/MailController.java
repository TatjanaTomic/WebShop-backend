package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.mail.MailService;
import org.unibl.etf.ip.shop.models.entities.Mail;

@RestController
@RequestMapping("/api/v1/email")
@CrossOrigin(origins="*")
public class MailController {

    private MailService mailService;
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping
    public String insert(@RequestBody Mail mail) {
        return mailService.sendSimpleMail(mail);
    }
}
