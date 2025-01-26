package ru.javaguru.rentals.usecases.mapper;

import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import ru.javaguru.rentals.persistence.model.Rental;
import ru.javaguru.rentals.usecases.dto.RentalDto;
import ru.javaguru.rentals.usecases.dto.VehicleDto;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        builder = @Builder(disableBuilder = true))
public interface RentalMapper {

    RentalDto toDto(Rental rental, VehicleDto vehicle);
}
