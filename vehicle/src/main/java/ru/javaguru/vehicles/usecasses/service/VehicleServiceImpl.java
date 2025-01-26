package ru.javaguru.vehicles.usecasses.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javaguru.vehicles.persistence.repository.VehicleRepository;
import ru.javaguru.vehicles.usecasses.VehicleService;
import ru.javaguru.vehicles.usecasses.dto.VehicleDto;
import ru.javaguru.vehicles.usecasses.mapper.VehicleMapper;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleMapper vehicleMapper;

    @Override
    public VehicleDto findVehicle(long id) {
        return vehicleMapper.toDto(vehicleRepository.getVehicle(id));
    }

}