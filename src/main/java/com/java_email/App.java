package com.java_email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		String message = "Hello Dear, This is first from java server";
		String to = "rpsharma7799@gmail.com";
		String from = "tulsi21sharma@gmail.com";
		String subject = "trail message";

		sendEmail(message, to, from, subject);
	}

	private static void sendEmail(String message, String to, String from, String subject) {

		String host = "smtp.gmail.com";

		Properties prop = System.getProperties();
		System.out.println("Properties" + prop);

		prop.put("mail.smtp.host", host);
		prop.put("mail.smtp.port", "465");
		prop.put("mail.smtp.ssl.enable", true);
		prop.put("mail.smtp.auth", true);

		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("tulsi21sharma@gmail.com", "P@nd@t@123456");
			}

		});

		session.setDebug(true);

		MimeMessage mymessage = new MimeMessage(session);

		try {
			mymessage.setFrom(from);
			mymessage.setSubject(subject);
			mymessage.setText(message);

			mymessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			Transport.send(mymessage);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
