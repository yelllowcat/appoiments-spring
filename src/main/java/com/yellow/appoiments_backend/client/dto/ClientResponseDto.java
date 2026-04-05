package com.yellow.appoiments_backend.client.dto;

public record ClientResponseDto(
                Long id,
                String username,
                String email,
                String phoneNumber) {
}