package com.yellow.appointments_backend.appointment;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.appointments_backend.appointment.dto.AppointmentCreateDto;
import com.yellow.appointments_backend.appointment.dto.AppointmentResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @GetMapping("/appointments")
    public List<AppointmentResponseDto> getAppointments() {
        return appointmentService.getAppointments();
    }

    @PostMapping("/appointments")
    public AppointmentResponseDto createAppointment(
            @Valid @RequestBody AppointmentCreateDto createDto) {
        return appointmentService.createAppointment(createDto);
    }
}
