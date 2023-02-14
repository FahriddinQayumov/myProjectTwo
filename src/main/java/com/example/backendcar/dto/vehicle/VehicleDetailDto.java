package com.example.backendcar.dto.vehicle;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class VehicleDetailDto {
    private UUID id;
    private UUID merchantId;
    private UUID brandId;
    private UUID modelId;
    private UUID bodyTypeId;
    private String name;
    private Integer year;
    private String color;
    private Integer numberSits;
    private Boolean isNew;
    private Double price;
    private Integer conditionDurationType;
    private Integer conditionDuration;
    private Double conditionPrice;
    private Boolean status;
}
