package com.example.backendcar.dto.brand;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BrandCreateDto {
    @NotBlank(message = ("invalid name"))
    private String name;
    private String logo;
    private Boolean status;
}
