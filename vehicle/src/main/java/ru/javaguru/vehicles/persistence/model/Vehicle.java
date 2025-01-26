package ru.javaguru.vehicles.persistence.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Vehicle {
    private Long id;
    private String make;
    private String model;
    private Integer year;
    private String type;

}