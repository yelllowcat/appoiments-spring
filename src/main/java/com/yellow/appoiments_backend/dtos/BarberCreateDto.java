package com.yellow.appoiments_backend.dtos;

public record BarberCreateDto(
        String username,
        String email,
        String phoneNumber,
        String password) {

}
