package ru.javaguru.rentals.usecases.dto;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class RentalDto {
    private Long rentalId;
    private Long userId;
    private Long vehicleId;
    private Integer rentalDays;
    private VehicleDto vehicle;
}
