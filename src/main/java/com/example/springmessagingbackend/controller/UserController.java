package com.example.springmessagingbackend.controller;

import com.example.springmessagingbackend.dto.users.request.CreateUserRequest;
import com.example.springmessagingbackend.dto.users.response.UserResponse;
import com.example.springmessagingbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    // POST (create account name)
    @PostMapping("/create-account")
    public UserResponse post (@RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping("/account/{id}")
    public UserResponse get (@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("my-chat/{id}")
    public UserResponse myChat (@PathVariable Long id) {
        return userService.getUserChat(id);
    }
}
