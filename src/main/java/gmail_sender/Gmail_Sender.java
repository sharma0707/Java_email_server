package gmail_sender;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;

import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class Gmail_Sender {
	
	public boolean sendEmail(String to, String from, String subject, String message) {
		
		boolean flag = false;
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host","smtp.gmail.com" );
		
		
		String username = "aws7530";
		String password = "password";
		
		jakarta.mail.Session session = jakarta.mail.Session.getInstance(properties, new jakarta.mail.Authenticator() {
			@Override
			protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new jakarta.mail.PasswordAuthentication(username, password);
			}
		});
		
		try {
			Message msg = new MimeMessage(session);
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setFrom(new InternetAddress(from));
			msg.setSubject(subject);
			msg.setText(message);
			
			jakarta.mail.Transport.send(msg);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return flag;
		
	}

}
