package ru.javaguru.vehicles.usecasses.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.javaguru.vehicles.persistence.model.Vehicle;
import ru.javaguru.vehicles.usecasses.dto.VehicleDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true))
public interface VehicleMapper {

    VehicleDto toDto(Vehicle vehicle);

    Vehicle toEntity(VehicleDto vehicleDto);
}
