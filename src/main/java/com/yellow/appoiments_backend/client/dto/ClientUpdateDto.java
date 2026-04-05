package com.yellow.appoiments_backend.client.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;

public record ClientUpdateDto(
                @Nullable String username,
                @Nullable @Email String email,
                @Nullable String phoneNumber,
                @Nullable String password) {

}
