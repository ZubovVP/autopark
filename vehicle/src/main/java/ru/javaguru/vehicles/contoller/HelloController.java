package ru.javaguru.vehicles.contoller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vehicles")
public class HelloController {

    @GetMapping
    public ResponseEntity<?> sayHello(){
        return ResponseEntity.ok("Hello, It's vehicles service!");
    }
}
