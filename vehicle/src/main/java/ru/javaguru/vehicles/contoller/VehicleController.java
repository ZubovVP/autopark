package ru.javaguru.vehicles.contoller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.javaguru.vehicles.usecasses.VehicleService;
import ru.javaguru.vehicles.usecasses.dto.VehicleDto;

@RestController
@RequestMapping("/vehicles")
@RequiredArgsConstructor
public class VehicleController {
    private final VehicleService vehicleService;

    @GetMapping("/{id}")
    public ResponseEntity<VehicleDto> getVehicleById(@PathVariable(name = "id") long id) {
        return ResponseEntity.ok(vehicleService.findVehicle(id));
    }

}