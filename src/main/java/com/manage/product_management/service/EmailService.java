package com.manage.product_management.service;

import com.manage.product_management.model.RecordTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Fetching the sender email from application.properties
    @Value("${spring.mail.username}")
    private String senderEmail;

    public void sendNewParcelNotification(RecordTable record) {
        // NOTE: We assume the recipient's email is stored in the RecordTable.
        // If not, you can hardcode one for testing, e.g., String recipientEmail = "test@example.com";
        // Let's assume your RecordTable has a getEmail() method.
        String recipientEmail = record.getEmail(); // Change this if the field name is different

        if (recipientEmail == null || recipientEmail.isEmpty()) {
            System.err.println("Recipient email is missing, cannot send notification.");
            return;
        }

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderEmail);
        message.setTo(recipientEmail);
        message.setSubject("New Parcel Registered! Tracking ID: " + record.getTrackId());
        message.setText("Hello,\n\nA new parcel has been registered for you.\n\n" +
                "Tracking ID: " + record.getTrackId() + "\n" +
                "Company: " + record.getCompName() + "\n\n" +
                "Please collect it at your convenience.\n\nThank you!");

        try {
            mailSender.send(message);
            System.out.println("Email sent successfully to " + recipientEmail);
        } catch (Exception e) {
            System.err.println("Error while sending email: " + e.getMessage());
        }
    }
}