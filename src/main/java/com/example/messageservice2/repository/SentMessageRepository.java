package com.example.messageservice2.repository;
import com.example.messageservice2.model.SentMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SentMessageRepository extends JpaRepository<SentMessage, Long> {
}
