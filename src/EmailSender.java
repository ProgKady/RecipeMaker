import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {
    public static void main(String[] args) {
        // SMTP server configuration
        String host = "smtp.gmail.com"; // Example: smtp.gmail.com
        final String username = "ahmedelkadyteeest@gmail.com";
        final String password = "lgrj esca tdtz froo"; // Use App Password for security

        // Recipient list
        String[] recipients = {"ahmed.elkady@tcgarments.com"};

        // Email content (choose Template 1 or 2)
        String subject = "Welcome to Our Service!";
        String emailContent = getTemplate1(); // Use getTemplate2() for the second template

        // SMTP properties
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587"); // Use 465 for SSL

        // Create session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            
            // Add multiple recipients
            InternetAddress[] recipientAddresses = new InternetAddress[recipients.length];
            for (int i = 0; i < recipients.length; i++) {
                recipientAddresses[i] = new InternetAddress(recipients[i]);
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddresses);

            message.setSubject(subject);
            message.setContent(emailContent, "text/html; charset=utf-8");

            // Send email
            Transport.send(message);
            System.out.println("Emails sent successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    // HTML Email Template 1
    private static String getTemplate1() {
        return "<html><body>" +
                "<h2>Welcome to Our Service!</h2>" +
                "<p>Dear Customer,</p>" +
                "<p>Thank you for joining us! We are excited to have you on board.</p>" +
                "<img src='https://via.placeholder.com/600x200' width='100%' alt='Header Image'>" +
                "<p>Best Regards,<br>Company Name</p>" +
                "<footer>&copy; 2025 Company Name. All rights reserved.</footer>" +
                "</body></html>";
    }

    // HTML Email Template 2
    private static String getTemplate2() {
        return "<html><body>" +
                "<h2>Exclusive Deal Just for You!</h2>" +
                "<p>Don't miss out on our limited-time offer. Click below to grab your discount now!</p>" +
                "<img src='https://via.placeholder.com/600x200' width='100%' alt='Promo Banner'>" +
                "<a href='#' style='background: #ff6600; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px;'>Shop Now</a>" +
                "<footer>&copy; 2025 Company Name. All rights reserved.</footer>" +
                "</body></html>";
    }
}
