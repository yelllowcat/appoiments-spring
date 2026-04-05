package com.yellow.appointments_backend.OfferedService.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Positive;

public record OfferedServiceUpdateDto(
                @Nullable String name,
                @Nullable String description,
                @Nullable @Positive Double price,
                @Nullable Boolean isActive) {

}
