package hello.services;

import hello.models.ResponseDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by silvian on 21/12/14.
 */

@Service
public class EmailService {

    private String recipientAddress = "devcon.demo9@gmail.com";

    @Autowired
    JavaMailSender mailSender;

    private SimpleMailMessage emailSetup(String fromEmail, String subject, String message) {

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setFrom(fromEmail);
        email.setSubject(subject);
        email.setText(message);

        return email;
    }

    public ResponseDataModel sendEmail(String name, String fromEmail, String subject, String message) {

        if(name != null && fromEmail != null && subject != null && message != null) {

            try {

                SimpleMailMessage email = emailSetup(fromEmail, subject, message);
                mailSender.send(email);

                return new ResponseDataModel(true,"Message sent successfully!");

            } catch(Exception e) {
                e.printStackTrace();
                return new ResponseDataModel(false, "Failed to send message!");
            }
        }

        return new ResponseDataModel(false,"Failed to send message!");
    }

}
