package com.example.springmessagingbackend.service;

import com.example.springmessagingbackend.dto.users.request.CreateUserRequest;
import com.example.springmessagingbackend.dto.users.response.UserResponse;
import com.example.springmessagingbackend.entity.Message;
import com.example.springmessagingbackend.entity.User;
import com.example.springmessagingbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // Create Account
    public UserResponse createUser(CreateUserRequest request) {
        User user = User.builder()
                .name(request.getName())
                .build();

        User saved  = userRepository.save(user);
        return UserResponse.builder()

                .name(saved.getName())
                .build();
    }

    public UserResponse getUser (Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserResponse.builder()
                .name(user.getName())
                .build();
    }

    public UserResponse getUserChat (Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return UserResponse.builder()
                .name(user.getName())
                .messages(
                        user.getMessages()
                                .stream()
                                .map(Message::getContent)
                                .toList()
                )
                .build();
    }
}
