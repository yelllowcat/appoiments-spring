package com.yellow.appointments_backend.appointment;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yellow.appointments_backend.appointment.dto.AppointmentCreateDto;
import com.yellow.appointments_backend.appointment.dto.AppointmentResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentMapper appointmentMapper;
    private final AppointmentRepository appointmentRepository;

    public List<AppointmentResponseDto> getAppointments() {
        return appointmentRepository.findAll().stream()
                .map(appointmentMapper::toResponseDto)
                .toList();
    }

    public AppointmentResponseDto createAppointment(AppointmentCreateDto createDto) {
        Appointment appointment = appointmentMapper.toEntity(createDto);
        if (appointment == null) {
            throw new IllegalArgumentException("Invalid appointment data");
        }
        Appointment savedAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toResponseDto(savedAppointment);
    }

}
