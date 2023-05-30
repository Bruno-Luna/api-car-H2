package br.com.jcar.projectapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_carro")
@Data
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "car-uuid")
    @GenericGenerator(name = "car-uuid", strategy = "uuid2")
    private String idCar;

    @NotBlank(message = "Campo precisa ser preenchido.")
    @Column(name = "modelo")
    private String model;

    @NotBlank(message = "Campo precisa ser preenchido.")
    @Column(name = "marca")
    private String brand;

    @Column(name = "preço_normal")
    private Double regularPrice;

    @Column(name = "preço_total")
    private Double totalPrice;

    @Column(name = "porcentagem_juro")
    private Double percent;
}
