package org.unibl.etf.ip.shop.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.shop.models.entities.Mail;


@Service
public class MailService {
	
	private static final String SENDER_NAME = "WebShopIP";
	private static final String TITLE = "PIN";

	private JavaMailSender javaMailSender;

	public MailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	public String sendSimpleMail(Mail mail)
	{
		try {
			SimpleMailMessage mailMessage
					= new SimpleMailMessage();

			mailMessage.setFrom(SENDER_NAME);
			mailMessage.setTo(mail.getReceiver());
			mailMessage.setText(mail.getContent());
			mailMessage.setSubject(TITLE);

			javaMailSender.send(mailMessage);
			return "Mail je poslan.";
		}
		catch (Exception e) {
			return "Dogodila se greska prilikom slanja maila.";
		}
	}

}
