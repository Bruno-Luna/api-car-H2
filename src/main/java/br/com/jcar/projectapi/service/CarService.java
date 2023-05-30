package br.com.jcar.projectapi.service;

import br.com.jcar.projectapi.dto.CarDTO;
import br.com.jcar.projectapi.entity.Car;
import br.com.jcar.projectapi.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public CarDTO carValueWithInterest(CarDTO carDTO){
        Car car = new Car();

        double carPrice = carDTO.getRegularPrice();
        double percent = carDTO.getPercent();
        double totalValue = carPrice += carPrice * percent;

        car.setBrand(carDTO.getBrand());
        car.setRegularPrice(carDTO.getRegularPrice());
        car.setTotalPrice(totalValue);
        car.setModel(carDTO.getModel());
        car.setPercent(carDTO.getPercent());

        carRepository.save(car);

        return carDTO;
    }

    public ResponseEntity<List<Car>> listAllCar(){
        List<Car> listCar =  carRepository.findAll();

        if(listCar.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listCar);

    }

    public ResponseEntity<Object> checkCarExist(Car requestUpdateCar){
        if(carRepository.existsById(requestUpdateCar.getIdCar())){
            return ResponseEntity.status(200).body(carRepository.save(requestUpdateCar));
        }
        return new ResponseEntity<>("Carro não encontrado.", HttpStatus.BAD_REQUEST);
    }
}
