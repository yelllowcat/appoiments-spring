package com.yellow.appoiments_backend.barber;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.barber.dto.BarberCreateDto;
import com.yellow.appoiments_backend.barber.dto.BarberResponseDto;
import com.yellow.appoiments_backend.barber.dto.BarberUpdateDto;
import com.yellow.appoiments_backend.user.User;
import com.yellow.appoiments_backend.utils.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarberService {

    private final BarberRepository barberRepository;

    private final BarberMapper barberMapper;

    public List<BarberResponseDto> getAllBarbers() {
        return barberRepository.findAll().stream()
                .map(barberMapper::toBarberResponseDto)
                .collect(Collectors.toList());
    }

    public BarberResponseDto getBarberById(Long id) {
        Barber barber = barberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barber not found with id: " + id));
        return barberMapper.toBarberResponseDto(barber);
    }

    public BarberResponseDto createBarber(BarberCreateDto dto) {

        Barber barber = barberMapper.toBarber(dto);

        barber.getUser().setPassword(dto.password());
        barber.getUser().setRole(Role.BARBER);

        Barber savedBarber = barberRepository.save(barber);
        return barberMapper.toBarberResponseDto(savedBarber);
    }

    public BarberResponseDto updateBarber(Long id, BarberUpdateDto dto) {
        Barber existingBarber = barberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Barber not found with id: " + id));

        User user = existingBarber.getUser();

        if (dto.username() != null && !dto.username().isEmpty()) {
            user.setUsername(dto.username());
        }
        if (dto.email() != null && !dto.email().isEmpty()) {
            user.setEmail(dto.email());
        }
        if (dto.phoneNumber() != null && !dto.phoneNumber().isEmpty()) {
            user.setPhoneNumber(dto.phoneNumber());
        }
        if (dto.password() != null && !dto.password().isEmpty()) {
            user.setPassword(dto.password());
        }

        Barber updatedBarber = barberRepository.save(existingBarber);

        return barberMapper.toBarberResponseDto(updatedBarber);
    }

    public void deleteBarber(Long id) {
        barberRepository.deleteById(id);
    }
}
