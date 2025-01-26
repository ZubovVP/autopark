package ru.javaguru.vehicles.persistence.repository;

import org.springframework.stereotype.Repository;
import ru.javaguru.vehicles.persistence.model.Vehicle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class VehicleRepository {

    private final Map<Long, Vehicle> vehicles = new ConcurrentHashMap<>();

    {
        vehicles.put(1L, new Vehicle(1L, "Toyota", "Corolla", 2020, "Легковой"));
        vehicles.put(2L, new Vehicle(2L, "Nissan", "Murano", 1996, "Легковой"));
        vehicles.put(3L, new Vehicle(3L, "Opel", "Vectra", 2000, "Легковой"));
    }

    public Vehicle getVehicle(long id) {
        return vehicles.get(id);
    }

}