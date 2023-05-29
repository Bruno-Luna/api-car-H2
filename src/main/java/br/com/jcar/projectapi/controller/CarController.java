package br.com.jcar.projectapi.controller;

import br.com.jcar.projectapi.dto.CarDTO;
import br.com.jcar.projectapi.entity.Car;
import br.com.jcar.projectapi.repository.CarRepository;
import br.com.jcar.projectapi.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/add")
    private CarDTO add(@RequestBody CarDTO requestCar){
        return carService.valueCarWithInterest(requestCar);
    }
}
