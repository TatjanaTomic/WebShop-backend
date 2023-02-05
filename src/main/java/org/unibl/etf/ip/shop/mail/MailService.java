package org.unibl.etf.ip.shop.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//@Service
public class MailService {
	
	private Properties props = new Properties();
	
	private static final String SENDER_NAME = "WebShopIP";
	private static final String TITLE = "PIN";
		
	private static String senderMail = "tatjanatomic997@gmail.com";
	private static String senderPass = "xegrvfpywecevxgd";


	//@Autowired
	//private JavaMailSender javaMailSender;

	@Value("${spring.mail.username}") private String sender;
	
	private MailService() {
		props.setProperty("spring.mail.host","smtp.gmail.com");
		props.setProperty("spring.mail.port","465");
		props.setProperty("spring.mail.username",senderMail);
		props.setProperty("spring.mail.password",senderPass);
		props.setProperty("spring.mail.properties.mail.smtp.auth", "true");
		props.setProperty("spring.mail.properties.mail.smtp.starttls.enable", "true");

//		props.setProperty("mail.smtp.socketFactory.port","465");
//		props.setProperty("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
//		props.setProperty("mail.smtp.auth","true");
//		props.setProperty("mail.smtp.starttls.enable","true");
//		props.setProperty("mail.smtp.ssl.protocols","TLSv1.2");
	}


	// Method 1
	// To send a simple email
	public boolean sendMail(String receiver, String content)
	{

		// Try block to check for exceptions
		try {

			// Creating a simple mail message
			SimpleMailMessage mailMessage
					= new SimpleMailMessage();

			// Setting up necessary details
			mailMessage.setFrom(sender);
			mailMessage.setTo(receiver);
			mailMessage.setText(content);
			mailMessage.setSubject(TITLE);

			// Sending the mail
			//javaMailSender.send(mailMessage);
			return true;
		}

		// Catch block to handle the exceptions
		catch (Exception e) {
			return false;
		}
	}
	
}
