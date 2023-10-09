package com.example.messageservice2.service;
import com.example.messageservice2.model.SentMessage;
import com.example.messageservice2.repository.SentMessageRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private SentMessageRepository sentMessageRepository;
    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, "utf-8");
            helper.setText(text, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setFrom("arys.java@mail.ru");
            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @KafkaListener(topics = "message_topic", groupId = "email_service_group")
    public void listen(String messageString) {
        ObjectMapper objectMapper = new ObjectMapper();
        SentMessage message = null;
        try {
            message = objectMapper.readValue(messageString, SentMessage.class);
                           //Укажите адрес электронной почты куда вы хотите получить сообщение.
            sendSimpleMessage("chenemesov01@gmail.com", "Новое сообщение от " + message.getSender(), message.getContent());
            message.setResponseCode("SUCCESS");
        }
        catch (JsonProcessingException e) {
            e.printStackTrace();
            message = new SentMessage();
            message.setResponseCode("FAILED");
        }
        finally {
            sentMessageRepository.save(message);
        }
    }
}

