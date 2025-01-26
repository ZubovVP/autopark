package ru.javaguru.rentals.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ru.javaguru.rentals.usecases.RentalService;
import ru.javaguru.rentals.usecases.dto.RentalDto;

@RestController
@RequiredArgsConstructor
@RequestMapping("/rentals")
public class RentalController {
    private RestTemplate restTemplate;
    private final RentalService rentalService;

    @GetMapping("/{id}")
    public ResponseEntity<RentalDto> getRentalById(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.findById(id));
    }


}
