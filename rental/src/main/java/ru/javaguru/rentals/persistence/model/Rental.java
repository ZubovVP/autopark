package ru.javaguru.rentals.persistence.model;

import lombok.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Rental {
    private Long rentalId;
    private Long userId;
    private Long vehicleId;
    private Integer rentalDays;
}
