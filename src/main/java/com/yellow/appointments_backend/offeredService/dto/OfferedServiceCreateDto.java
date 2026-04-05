package com.yellow.appointments_backend.offeredService.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OfferedServiceCreateDto(
        @NotBlank String name,
        @NotBlank String description,
        @NotNull @Positive Double price) {

}
