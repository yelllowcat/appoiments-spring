package com.yellow.appoiments_backend.dtos;

public record ClientCreateDto(
                String username,
                String email,
                String phoneNumber,
                String password) {
}