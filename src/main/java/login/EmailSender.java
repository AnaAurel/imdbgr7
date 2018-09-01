package login;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

// vezi https://stackoverflow.com/questions/3649014/send-email-using-java, raspunsul cu 41 voturi

public class EmailSender {

    public static void send(String to, String subject, String text) throws MessagingException {
        String senderEmail = "calinveltan8@gmail.com"; // pun datele mele
        String senderPassword = "calin4321";

        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(senderEmail, senderPassword);
                    }
                });

        Message message = new MimeMessage(session);
        message.setFrom(InternetAddress.parse(senderEmail)[0]);
        message.setRecipient(Message.RecipientType.TO,InternetAddress.parse(to)[0]);
        message.setSubject(subject);
        message.setText(text);
        Transport.send(message);
        System.out.println("Sent email message.");
    }

}
