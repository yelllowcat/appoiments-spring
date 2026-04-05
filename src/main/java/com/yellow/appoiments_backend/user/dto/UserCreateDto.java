package com.yellow.appoiments_backend.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record UserCreateDto(
        @NotEmpty String username,
        @NotEmpty @Email String email,
        @NotEmpty String phoneNumber,
        @NotEmpty String password) {
}