package com.example.springmessagingbackend.controller;

import com.example.springmessagingbackend.dto.messages.request.CreateMessageRequest;
import com.example.springmessagingbackend.dto.messages.response.MessageResponse;
import com.example.springmessagingbackend.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/create-message")
    public MessageResponse post (@RequestBody CreateMessageRequest request) {
        return messageService.createMessage(request);
    }
}
