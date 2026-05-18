package com.example.springmessagingbackend.dto.messages.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateMessageRequest {
    @NotBlank
    private String content;

    @NotNull
    private Long userId;
}
