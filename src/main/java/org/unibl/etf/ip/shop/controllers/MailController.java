package org.unibl.etf.ip.shop.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.mail.MailService;
import org.unibl.etf.ip.shop.models.entities.Mail;

@RestController
@RequestMapping("/api/v1/email")
@CrossOrigin(origins="http://localhost:4200/")
public class MailController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public boolean insert(@RequestBody Mail mail) throws Exception {
        //return MailService.getMailService().sendMail(mail.getReceiver(), mail.getContent());
        return false;
    }
}
