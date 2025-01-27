package ru.javaguru.rentals.usecases.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import ru.javaguru.rentals.persistence.model.Rental;
import ru.javaguru.rentals.persistence.repository.RentalRepository;
import ru.javaguru.rentals.usecases.RentalService;
import ru.javaguru.rentals.usecases.dto.RentalDto;
import ru.javaguru.rentals.usecases.dto.VehicleDto;
import ru.javaguru.rentals.usecases.mapper.RentalMapper;

@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService {
    private final RentalRepository rentalRepository;
    private final RentalMapper rentalMapper;
    private final WebClient webClient;


    @Override
    public RentalDto findById(Long id) {
        Rental rental = rentalRepository.getRental(id);

        VehicleDto vehicleDto = webClient.get()
                .uri("http://localhost:8082/vehicle-service/vehicles/" + rental.getVehicleId())
                .retrieve()
                .bodyToMono(VehicleDto.class)
                .block();
        return rentalMapper.toDto(rental, vehicleDto);
    }
}
