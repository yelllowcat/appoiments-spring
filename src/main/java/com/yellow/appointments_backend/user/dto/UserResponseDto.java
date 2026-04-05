package com.yellow.appointments_backend.user.dto;

public record UserResponseDto(
                Long id,
                String username,
                String email,
                String phoneNumber) {

}
