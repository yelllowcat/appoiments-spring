package com.yellow.appoiments_backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.appoiments_backend.dtos.BarberCreateDto;
import com.yellow.appoiments_backend.dtos.BarberResponseDto;
import com.yellow.appoiments_backend.dtos.BarberUpdateDto;
import com.yellow.appoiments_backend.services.BarberService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BarberController {

    private final BarberService barberService;

    @GetMapping("/barbers")
    public List<BarberResponseDto> getBarbers() {
        return barberService.getAllBarbers();
    }

    @GetMapping("/barbers/{id}")
    public BarberResponseDto getBarberById(@PathVariable Long id) {
        return barberService.getBarberById(id);
    }

    @PostMapping("/barbers")
    public BarberResponseDto createBarber(
            @Valid @RequestBody BarberCreateDto dto) {
        return barberService.createBarber(dto);
    }

    @PostMapping("/barbers/{id}")
    public BarberResponseDto updateBarber(@PathVariable Long id, @Valid @RequestBody BarberUpdateDto dto) {
        return barberService.updateBarber(id, dto);
    }

    @DeleteMapping("/barbers/{id}")
    public void deleteBarber(
            @PathVariable Long id) {
        barberService.deleteBarber(id);
    }
}
