package br.com.jcar.projectapi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarDTO {

    private String model;
    private String brand;
    private Double regularPrice;
    private Double totalPrice;
    private Double percent;

    public CarDTO(String model, String brand, Double regularPrice, Double totalPrice, Double percent){
        this.model = model;
        this.brand = brand;
        this.regularPrice = regularPrice;
        this.totalPrice = totalPrice;
        this.percent = percent;
    }
}
