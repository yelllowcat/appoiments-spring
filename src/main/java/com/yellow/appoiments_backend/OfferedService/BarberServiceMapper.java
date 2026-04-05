package com.yellow.appoiments_backend.OfferedService;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.OfferedService.dto.BarberServiceCreateDto;
import com.yellow.appoiments_backend.OfferedService.dto.BarberServiceResponseDto;

@Service
public class BarberServiceMapper {

    public BarberServiceResponseDto toResponseDto(BarberService service) {
        if (service == null) {
            return null;
        }
        return new BarberServiceResponseDto(
                service.getId(),
                service.getName(),
                service.getDescription(),
                service.getPrice(),
                service.getIsActive());
    }

    public BarberService toBarberService(BarberServiceCreateDto dto) {
        if (dto == null) {
            return null;
        }
        return new BarberService(
                dto.name(),
                dto.description(),
                dto.price(),
                true);
    }
}
