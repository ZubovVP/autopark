package ru.javaguru.rentals.persistence.repository;

import org.springframework.stereotype.Repository;
import ru.javaguru.rentals.persistence.model.Rental;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RentalRepository {

    private final Map<Long, Rental> rentals = new ConcurrentHashMap<>();

    {
        rentals.put(1L, new Rental(1L, 1L, 1L, 10));
        rentals.put(2L, new Rental(2L, 2L, 2L, 20));
        rentals.put(3L, new Rental(3L, 2L, 3L, 30));
    }

    public Rental getRental(long id) {
        return rentals.get(id);
    }

}