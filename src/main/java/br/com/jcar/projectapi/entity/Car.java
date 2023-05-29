package br.com.jcar.projectapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_car")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "car-uuid")
    @GenericGenerator(name = "car-uuid", strategy = "uuid2")
    private String idCar;

    @NotBlank(message = "Campo precisa ser preenchido.")
    @Column(name = "Modelo")
    private String model;

    @NotBlank(message = "Campo precisa ser preenchido.")
    @Column(name = "Marca")
    private String brand;

    @Column(name = "Preço normal")
    private Double regularPrice;

    @Column(name = "Preço Total")
    private Double totalPrice;

    @Column(name = "Juros")
    private Double percent;
}
