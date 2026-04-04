package com.yellow.appoiments_backend.dtos;

public record UserCreateDto(
        String username,
        String email,
        String phoneNumber,
        String password) {
}