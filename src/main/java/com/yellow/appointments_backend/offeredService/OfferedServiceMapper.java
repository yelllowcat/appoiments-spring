package com.yellow.appointments_backend.OfferedService;

import org.springframework.stereotype.Service;

import com.yellow.appointments_backend.OfferedService.dto.OfferedServiceCreateDto;
import com.yellow.appointments_backend.OfferedService.dto.OfferedServiceResponseDto;

@Service
public class OfferedServiceMapper {

    public OfferedServiceResponseDto toResponseDto(OfferedService service) {
        if (service == null) {
            return null;
        }
        return new OfferedServiceResponseDto(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getPrice(),
                service.getIsActive());
    }

    public OfferedService toBarberService(OfferedServiceCreateDto dto) {
        if (dto == null) {
            return null;
        }
        return new OfferedService(
                dto.name(),
                dto.description(),
                dto.price(),
                true);
    }
}
