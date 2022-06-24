package ch.ydavid.simplebiblio.daemon;

import ch.ydavid.simplebiblio.backend.BorrowManagement;
import ch.ydavid.simplebiblio.dto.Borrowed;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;


public class Daemon {

    final static String host = "192.168.1.79";
    final static int port = 25;
    final static String user = "m304-1@aprentasmail.com";
    final static String password = "Mail304.atB";

    public static void main(String[] args) {
        try {
            // Eigenschaften fuer Java Mail-API setzen
            Properties props = new Properties();
            props.setProperty("mail.smtp.auth", "true");
            props.setProperty("mail.smtp.host", host);
            props.setProperty("mail.smtp.port", String.valueOf(port));

            // Session erzeugen
            Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(user, password);
                }
            });

            // Email erstellen: Absender, Empfaenger, Betreff und Inhalt
            // ausfuellen
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(user));

            for (Borrowed b : fetchCrimes()) {
                try {
                    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(b.getUser().getMail()));
                    msg.setSubject("Bitte zurueckgeben Sie Ihren Ausleihungsauftrag");
                    msg.setText("Sie haben einen Ausleihungsauftrag zu " + b.getItem().getTitel() + " erhalten. Bitte zurueckgeben Sie Ihren Ausleihungsauftrag.");
                    Transport.send(msg);
                    System.out.println("Email gesendet an " + b.getUser().getUsername());
                } catch (Exception e) {
                    System.out.println("Mail an User " + b.getUser().getUsername() + " ist fehlgeschlagen!");
                }
            }

            System.out.println("all messages sent successfully...");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Borrowed> fetchCrimes() {

        BorrowManagement borrowManager = new BorrowManagement();

        return borrowManager.getUnreturnedEntries();

    }

}
