package ru.javaguru.vehicles.contoller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayHello")
public class HelloController {
    @Value("${eureka.instance.instance-id}")
    private String id;

    @GetMapping
    public ResponseEntity<?> sayHello(){
        return ResponseEntity.ok("Hello, It's vehicles service " + id);
    }
}
