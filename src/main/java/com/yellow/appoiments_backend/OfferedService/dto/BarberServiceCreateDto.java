package com.yellow.appoiments_backend.OfferedService.dto;

import jakarta.validation.constraints.NotBlank;

public record BarberServiceCreateDto(
                @NotBlank String name,
                @NotBlank String description,
                @NotBlank Double price) {

}
