package com.java_email;

import gmail_sender.Gmail_Sender;

public class App {
	public static void main(String[] args) {
		
//		String message = "Hello Dear, This is first from java server";
//		String to = "rpsharma7799@gmail.com";
//		String from = "tulsi21sharma@gmail.com";
//		String subject = "trail message";
//
//		sendEmail(message, to, from, subject);
//	}
//
//	private static void sendEmail(String message, String to, String from, String subject) {
//
//		String host = "smtp.gmail.com";
//
//		Properties prop = System.getProperties();
//		System.out.println("Properties" + prop);
//
//		prop.put("mail.smtp.host", host);
//		prop.put("mail.smtp.port", "465");
//		prop.put("mail.smtp.ssl.enable", true);
//		prop.put("mail.smtp.auth", true);
//
//		Session session = Session.getInstance(prop, new Authenticator() {
//
//			@Override
//			protected PasswordAuthentication getPasswordAuthentication() {
//				// TODO Auto-generated method stub
//				return new PasswordAuthentication("tulsi21sharma@gmail.com", "P@nd@t@123456");
//			}
//
//		});
//
//		session.setDebug(true);
//
//		MimeMessage mymessage = new MimeMessage(session);
//
//		try {
//			mymessage.setFrom(from);
//			mymessage.setSubject(subject);
//			mymessage.setText(message);
//
//			mymessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//
//			Transport.send(mymessage);
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
		
		Gmail_Sender gmail_sender = new Gmail_Sender();
		String to ="";
		String from ="";
		String subject ="";
		String message ="";
		
	boolean	b = gmail_sender.sendEmail(to, from, subject, message);
	if(b) {
		System.out.println("email sent sucessfully");
	}
	else {
		System.out.println("something went wrong");
	}
		
}
	}
