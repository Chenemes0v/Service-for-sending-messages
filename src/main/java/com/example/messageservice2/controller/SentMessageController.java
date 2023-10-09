package com.example.messageservice2.controller;
import com.example.messageservice2.model.SentMessage;
import com.example.messageservice2.repository.SentMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/sent-messages")
public class SentMessageController {
    @Autowired
    private SentMessageRepository sentMessageRepository;

    @GetMapping
    public ResponseEntity<List<SentMessage>> getAllSentMessages() {
        return new ResponseEntity<>(sentMessageRepository.findAll(), HttpStatus.OK);
    }
}
