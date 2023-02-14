package com.example.backendcar.dto.model;

import com.example.backendcar.model.Brand;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ModelDetailDto {
    private UUID id;
    private String name;
    private Boolean status;
    private Brand brand;
    private UUID brandId;
}
