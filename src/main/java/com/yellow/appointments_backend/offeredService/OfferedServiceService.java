package com.yellow.appointments_backend.OfferedService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.yellow.appointments_backend.OfferedService.dto.OfferedServiceCreateDto;
import com.yellow.appointments_backend.OfferedService.dto.OfferedServiceResponseDto;
import com.yellow.appointments_backend.OfferedService.dto.OfferedServiceUpdateDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OfferedServiceService {

    private final OfferedServiceRepository serviceRepository;

    private final OfferedServiceMapper serviceMapper;

    public OfferedServiceResponseDto getServiceById(Long id) {
        return serviceMapper.toResponseDto(serviceRepository.findById(id).orElse(null));
    }

    public List<OfferedServiceResponseDto> getAllServices() {
        return serviceRepository.findAll().stream()
                .map(serviceMapper::toResponseDto)
                .collect(Collectors.toList());
    }

    public OfferedServiceResponseDto createService(OfferedServiceCreateDto dto) {
        OfferedServiceResponseDto responseDto = serviceMapper.toResponseDto(
                serviceRepository.save(serviceMapper.toBarberService(dto)));
        return responseDto;
    }

    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    public OfferedServiceResponseDto updateService(Long id, OfferedServiceUpdateDto dto) {
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
