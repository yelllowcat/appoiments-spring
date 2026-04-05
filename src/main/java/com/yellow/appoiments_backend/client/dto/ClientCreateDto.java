package com.yellow.appoiments_backend.client.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClientCreateDto(
                @NotBlank String username,
                @NotBlank @Email String email,
                @NotBlank String phoneNumber,
                @NotBlank String password) {
}