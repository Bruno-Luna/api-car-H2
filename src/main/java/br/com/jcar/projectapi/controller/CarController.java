package br.com.jcar.projectapi.controller;

import br.com.jcar.projectapi.dto.CarDTO;
import br.com.jcar.projectapi.entity.Car;
import br.com.jcar.projectapi.repository.CarRepository;
import br.com.jcar.projectapi.service.CarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping("/add-car")
    private CarDTO addCar(@RequestBody CarDTO requestCar){
        return carService.carValueWithInterest(requestCar);
    }

    @GetMapping
    private ResponseEntity<List<Car>> getAllCar(){
        return carService.listAllCar();
    }

    @PutMapping("/alter-car")
    private ResponseEntity<Object> alterCar(@RequestBody Car requestUpdateCar){
        return carService.checkCarExist(requestUpdateCar);
    }
}
