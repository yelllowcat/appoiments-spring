package com.yellow.appoiments_backend.dtos;

public record ClientResponseDto(
        Long id,
        String username,
        String email,
        String phoneNumber) {
}