package com.example.backendcar.dto.vehicle;

import com.example.backendcar.model.BodyType;
import com.example.backendcar.model.Brand;
import com.example.backendcar.model.Model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class VehicleCreateDto {
    private UUID merchantId;
    private UUID brandId;
    private UUID modelId;
    private UUID bodyTypeId;
    @NotBlank(message = ("invalid name"))
    private String name;
    private Integer year;
    @NotBlank(message = ("invalid color"))
    private String color;
    private Integer numberSits;
    private Boolean isNew;
    private Double price;
    private Integer conditionDurationType;
    private Integer conditionDuration;
    private Double conditionPrice;
    private Boolean status;
}
