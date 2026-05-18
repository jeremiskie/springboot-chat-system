package com.example.springmessagingbackend.repository;

import com.example.springmessagingbackend.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
