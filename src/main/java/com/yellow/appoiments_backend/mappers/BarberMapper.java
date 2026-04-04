package com.yellow.appoiments_backend.mappers;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.dtos.BarberCreateDto;
import com.yellow.appoiments_backend.dtos.BarberResponseDto;
import com.yellow.appoiments_backend.models.Barber;
import com.yellow.appoiments_backend.models.User;
import com.yellow.appoiments_backend.utils.Role;

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
