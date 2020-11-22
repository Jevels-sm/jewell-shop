import java.util.Properties;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Authenticator;
import javax.mail.Message;
//import javax.activation.DataHandler;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;

public class sendMail {
	public static void sendMail(String recipient,String username,String userpwd, String msg) throws MessagingException {
		Properties properties= new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		final String myAccount="shopjewel6@gmail.com";
		final String pwd= "098@megha";
		Session session= Session.getInstance(properties,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccount,pwd);
			}
			
			
		});
		Message message = prepareMessage(session, myAccount,recipient, username, userpwd,msg);
		Transport.send(message);
	}
	private static Message prepareMessage(Session session, String myAccount, String recipient, String username, String userpwd, String msg) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myAccount));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
			message.setSubject("Registration confirmed !!!");
			message.setText(msg+"\n USERNAME:"+ username + "\n PASSWORD:"+ userpwd);
			return message;
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
