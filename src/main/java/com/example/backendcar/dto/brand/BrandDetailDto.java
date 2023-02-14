package com.example.backendcar.dto.brand;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import java.util.UUID;
@Getter
@Setter

public class BrandDetailDto {
    private UUID id;
    private String name;
    private String logo;
    private Boolean status;
}
