package com.yellow.appoiments_backend.dtos;

public record BarberResponseDto(
        Long id,
        String username,
        String email,
        String phoneNumber) {
}
