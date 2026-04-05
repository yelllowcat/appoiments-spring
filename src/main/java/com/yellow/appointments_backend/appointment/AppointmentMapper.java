package com.yellow.appointments_backend.appointment;

import org.springframework.stereotype.Component;

import com.yellow.appointments_backend.OfferedService.OfferedService;
import com.yellow.appointments_backend.appointment.dto.AppointmentCreateDto;
import com.yellow.appointments_backend.appointment.dto.AppointmentResponseDto;
import com.yellow.appointments_backend.barber.Barber;
import com.yellow.appointments_backend.client.Client;

@Component
public class AppointmentMapper {

    public AppointmentResponseDto toResponseDto(Appointment appointment) {

        if (appointment == null) {
            return null;
        }
        return new AppointmentResponseDto(
                appointment.getId(),
                appointment.getService() != null ? appointment.getService().getId() : null,
                appointment.getBarber() != null ? appointment.getBarber().getId() : null,
                appointment.getClient() != null ? appointment.getClient().getId() : null,
                appointment.getAppointmentDate(),
                appointment.getStatus());
    }

    public Appointment toEntity(AppointmentCreateDto createDto) {
        if (createDto == null) {
            return null;
        }
        Appointment appointment = new Appointment();

        OfferedService service = new OfferedService();

        Barber barber = new Barber();

        Client client = new Client();

        service.setId(createDto.serviceId());
        barber.setId(createDto.barberId());
        client.setId(createDto.clientId());

        appointment.setService(service);

        appointment.setBarber(barber);
        appointment.setClient(client);

        appointment.setAppointmentDate(createDto.appointmentDate());
        appointment.setStatus(createDto.status());
        return appointment;

    }
}