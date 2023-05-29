package br.com.jcar.projectapi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CarDTO {

    private String model;
    private String brand;
    private Double regularPrice;
    private Double totalPrice;
    private Double percent;
}
