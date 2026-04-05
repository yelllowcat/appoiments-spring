package com.yellow.appoiments_backend.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.appoiments_backend.dtos.BarberServiceCreateDto;
import com.yellow.appoiments_backend.dtos.BarberServiceResponseDto;
import com.yellow.appoiments_backend.dtos.BarberServiceUpdateDto;
import com.yellow.appoiments_backend.services.BarberServiceService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BarberServiceController {

    private final BarberServiceService barberService;

    @GetMapping("/services")
    public List<BarberServiceResponseDto> getServices() {
        return barberService.getAllServices();
    }

    @GetMapping("/services/{id}")
    public BarberServiceResponseDto getServiceById(@PathVariable Long id) {
        return barberService.getServiceById(id);
    }

    @PostMapping("/services")
    public BarberServiceResponseDto createService(@Valid BarberServiceCreateDto dto) {
        return barberService.createService(dto);
    }

    @PostMapping("/services/{id}")
    public BarberServiceResponseDto updateService(@PathVariable Long id, @Valid BarberServiceUpdateDto dto) {
        return barberService.updateService(id, dto);
    }

    @DeleteMapping("/services/{id}")
    public void deleteService(@PathVariable Long id) {
        barberService.deleteService(id);
    }

}