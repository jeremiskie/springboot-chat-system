package com.example.springmessagingbackend.repository;

import com.example.springmessagingbackend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
