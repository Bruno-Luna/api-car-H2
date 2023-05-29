package br.com.jcar.projectapi.service;

import br.com.jcar.projectapi.dto.CarDTO;
import br.com.jcar.projectapi.entity.Car;
import br.com.jcar.projectapi.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CarService {

    @Autowired
    CarRepository carRepository;

    public CarDTO valueCarWithInterest(CarDTO carDTO){
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
}
