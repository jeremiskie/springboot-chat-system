package com.example.springmessagingbackend.service;

import com.example.springmessagingbackend.dto.messages.request.CreateMessageRequest;
import com.example.springmessagingbackend.dto.messages.response.MessageResponse;
import com.example.springmessagingbackend.entity.Message;
import com.example.springmessagingbackend.entity.User;
import com.example.springmessagingbackend.repository.MessageRepository;
import com.example.springmessagingbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final UserRepository userRepository;
    private final MessageRepository messageRepository;

    public MessageResponse createMessage (CreateMessageRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Message message = Message.builder()
                .content(request.getContent())
                .user(user)
                .build();

        Message saved = messageRepository.save(message);

        return MessageResponse.builder()
                .id(saved.getId())
                .content(saved.getContent())
                .build();
    }
}
