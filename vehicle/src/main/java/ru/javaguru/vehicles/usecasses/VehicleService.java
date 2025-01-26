package ru.javaguru.vehicles.usecasses;

import ru.javaguru.vehicles.usecasses.dto.VehicleDto;

public interface VehicleService {

    VehicleDto findVehicle(long id);

}