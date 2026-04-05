package com.yellow.appointments_backend.OfferedService;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yellow.appointments_backend.OfferedService.dto.OfferedServiceCreateDto;
import com.yellow.appointments_backend.OfferedService.dto.OfferedServiceResponseDto;
import com.yellow.appointments_backend.OfferedService.dto.OfferedServiceUpdateDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class OfferedServiceController {

    private final OfferedServiceService barberService;

    @GetMapping("/services")
    public List<OfferedServiceResponseDto> getServices() {
        return barberService.getAllServices();
    }

    @GetMapping("/services/{id}")
    public OfferedServiceResponseDto getServiceById(@PathVariable Long id) {
        return barberService.getServiceById(id);
    }

    @PostMapping("/services")
    public OfferedServiceResponseDto createService(@Valid @RequestBody OfferedServiceCreateDto dto) {
        return barberService.createService(dto);
    }

    @PostMapping("/services/{id}")
    public OfferedServiceResponseDto updateService(@PathVariable Long id,
            @Valid @RequestBody OfferedServiceUpdateDto dto) {
        return barberService.updateService(id, dto);
    }

    @DeleteMapping("/services/{id}")
    public void deleteService(@PathVariable Long id) {
        barberService.deleteService(id);
    }

}