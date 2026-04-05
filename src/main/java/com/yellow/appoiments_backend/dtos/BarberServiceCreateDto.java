package com.yellow.appoiments_backend.dtos;

import jakarta.validation.constraints.NotBlank;

public record ServiceCreateDto(
        @NotBlank String name,
        @NotBlank String description,
        @NotBlank Double price) {

}
