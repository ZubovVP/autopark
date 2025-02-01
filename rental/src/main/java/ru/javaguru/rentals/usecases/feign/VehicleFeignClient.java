package ru.javaguru.rentals.usecases.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.javaguru.rentals.usecases.dto.VehicleDto;

@FeignClient(name = "vehicle-service", fallback = VehicleFeignClientFallback.class)
public interface VehicleFeignClient {

    @GetMapping("/vehicles/{id}")
    ResponseEntity<VehicleDto> getVehicleById(@RequestParam("id") Long id);
}

@Component
class VehicleFeignClientFallback implements VehicleFeignClient {

    @Override
    public ResponseEntity<VehicleDto> getVehicleById(Long id) {
        return ResponseEntity.ok(new VehicleDto(999L, "TEST", "TEST", 1999, "Лековая"));
    }
}
