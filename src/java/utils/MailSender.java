package utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {

    private String username; // Địa chỉ email của người gửi
    private String password; // Mật khẩu email của người gửi
    private Properties properties;

    public MailSender() {
        this.username = "vuvo070403@gmail.com";
        this.password = "vsys zqgf eari hceu";

        properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Thay đổi host tùy theo dịch vụ email sử dụng
        properties.put("mail.smtp.port", "587"); // Cổng của SMTP server
        properties.put("mail.debug", "true"); // Bật chế độ debug để theo dõi chi tiết gửi email
    }

    public void sendEmail(String to, String subject, String content) {
        try {
            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); // Địa chỉ người gửi
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to)); // Địa chỉ người nhận
            message.setSubject(subject); // Tiêu đề email
            message.setContent(content, "text/html; charset=UTF-8");

            Transport.send(message); // Gửi email thành công

        } catch (MessagingException e) {

            throw new RuntimeException("Email sending failed", e);
        } catch (Exception e) {

            throw new RuntimeException("Unexpected error sending email", e);
        }
    }
}
