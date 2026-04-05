package com.yellow.appointments_backend.barber.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;

public record BarberUpdateDto(
                @Nullable String username,
                @Nullable @Email String email,
                @Nullable String phoneNumber,
                @Nullable String password) {

}
