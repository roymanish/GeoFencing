package com.manh.lm.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailService {

	public EmailService() {
		// TODO Auto-generated constructor stub
	}

	public Message getMimeMessage(String to,String cc) throws AddressException, MessagingException
	{
		final String username = "-";
		final String password = "";
		

		Properties props = new Properties();
		/*props.put("mail.transport.protocol", "smtps");
		props.put("mail.smtps.host", "smtp.bizmail.yahoo.com");
		props.put("mail.smtps.auth", true);
		props.put("mail.smtps.port", 465);
		props.put("mail.smtps.ssl.enable", true);*/
		
		props.put("mail.smtp.host", "smtp.bizmail.yahoo.com"); //SMTP Host
        props.put("mail.smtp.socketFactory.port", "465"); //SSL Port
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory"); //SSL Factory Class
        props.put("mail.smtp.auth", "true"); //Enabling SMTP Authentication
        props.put("mail.smtp.port", "465"); //SMTP Port
		
		

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("BITSAA Bangalore<"+username+">"));
		
		message.setRecipients(Message.RecipientType.BCC,
				InternetAddress.parse(username));

		if(to!=null && to.length()>1)
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(to));
		
		/*if(cc!=null && cc.length()>1)
			message.setRecipients(Message.RecipientType.CC,
					InternetAddress.parse(cc));*/




		return message;
	}
	
	

}
