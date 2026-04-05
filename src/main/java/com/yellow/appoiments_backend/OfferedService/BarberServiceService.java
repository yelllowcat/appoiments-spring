package com.yellow.appoiments_backend.OfferedService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yellow.appoiments_backend.OfferedService.dto.BarberServiceCreateDto;
import com.yellow.appoiments_backend.OfferedService.dto.BarberServiceResponseDto;
import com.yellow.appoiments_backend.OfferedService.dto.BarberServiceUpdateDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarberServiceService {

    private final BarberServiceRepository serviceRepository;

    private final BarberServiceMapper serviceMapper;

    public BarberServiceResponseDto getServiceById(Long id) {
        return serviceMapper.toResponseDto(serviceRepository.findById(id).orElse(null));
    }

    public List<BarberServiceResponseDto> getAllServices() {
        return serviceRepository.findAll().stream()
                .map(serviceMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public BarberServiceResponseDto createService(BarberServiceCreateDto dto) {
        BarberServiceResponseDto responseDto = serviceMapper.toResponseDto(
                serviceRepository.save(serviceMapper.toBarberService(dto)));
        return responseDto;
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public BarberServiceResponseDto updateService(Long id, BarberServiceUpdateDto dto) {
        return serviceRepository.findById(id)
                .map(existingService -> {
                    existingService.setName(dto.name());
                    existingService.setDescription(dto.description());
                    existingService.setPrice(dto.price());
                    existingService.setIsActive(dto.isActive());
                    return serviceMapper.toResponseDto(serviceRepository.save(existingService));
                })
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
    }

}
