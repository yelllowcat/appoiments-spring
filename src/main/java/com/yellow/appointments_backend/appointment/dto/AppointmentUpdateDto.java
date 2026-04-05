package com.yellow.appointments_backend.appointment.dto;

import jakarta.annotation.Nullable;

public record AppointmentUpdateDto(
                @Nullable Long id,
                @Nullable Long serviceId,
                @Nullable Long barberId,
                @Nullable Long clientId,
                @Nullable String appointmentDate) {

}
