package com.yellow.appoiments_backend.mappers;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.dtos.BarberServiceCreateDto;
import com.yellow.appoiments_backend.dtos.BarberServiceResponseDto;
import com.yellow.appoiments_backend.models.BarberService;

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
