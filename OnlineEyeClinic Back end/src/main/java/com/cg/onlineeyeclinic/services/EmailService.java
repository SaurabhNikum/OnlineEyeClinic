package com.cg.onlineeyeclinic.services;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import org.springframework.stereotype.Service;

@Service
public class EmailService 
{
	public boolean sendEmail(String message,String subject,String to)
	{
		boolean flag=false;
		
		//sender mail
		String from="onlineeyeclinicorg@gmail.com";
		
		//host 
		String host="smtp.gmail.com";
		
		//get system properties
		Properties proporties=System.getProperties();
		
		//set host
		proporties.put("mail.smtp.host", host);
		proporties.put("mail.smtp.port", "465");
		proporties.put("mail.smtp.ssl.enable", "true");
		proporties.put("mail.smtp.auth","true");
		
		//get session object
		Session session=Session.getInstance(proporties, new Authenticator() 
		{
			@Override
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication("onlineeyeclinicorg@gmail.com","Arun@123");
			}
		});
		
		//compose the message
		MimeMessage mimeMessage=new MimeMessage(session);
		
		try 
		{
			mimeMessage.setFrom(from);
			
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			
			mimeMessage.setSubject(subject);
			
			mimeMessage.setText(message);
			
			Transport.send(mimeMessage);
			
			System.out.println("Sent success ..........");
			
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return flag;
	}
}

