package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.models.entities.Mail;

public interface IMailService {

    String sendSimpleMail(Mail mail);
}
