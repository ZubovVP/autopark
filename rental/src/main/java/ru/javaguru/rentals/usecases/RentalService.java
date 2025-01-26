package ru.javaguru.rentals.usecases;

import ru.javaguru.rentals.usecases.dto.RentalDto;

public interface RentalService {
    RentalDto findById(Long id);

}
