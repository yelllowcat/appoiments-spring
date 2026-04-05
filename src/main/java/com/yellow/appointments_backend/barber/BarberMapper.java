package com.yellow.appointments_backend.barber;

import org.springframework.stereotype.Service;

import com.yellow.appointments_backend.barber.dto.BarberCreateDto;
import com.yellow.appointments_backend.barber.dto.BarberResponseDto;
import com.yellow.appointments_backend.user.User;
import com.yellow.appointments_backend.utils.Role;

@Service
public class BarberMapper {

    public Barber toBarber(BarberCreateDto dto) {
        if (dto == null) {
            return null;
        }
        Barber barber = new Barber();
        User user = new User();

        user.setRole(Role.BARBER);

        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPhoneNumber(dto.phoneNumber());
        user.setPassword(dto.password());
        barber.setUser(user);

        return barber;
    }

    public BarberResponseDto toBarberResponseDto(Barber barber) {
        if (barber == null) {
            return null;
        }
        return new BarberResponseDto(
                barber.getId(),
                barber.getUser().getUsername(),
                barber.getUser().getEmail(),
                barber.getUser().getPhoneNumber());
    }
}
