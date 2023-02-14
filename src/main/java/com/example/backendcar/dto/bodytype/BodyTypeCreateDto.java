package com.example.backendcar.dto.bodytype;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BodyTypeCreateDto {
    @NotBlank(message = ("invalid name"))
    private String name;
    private Boolean status;
}
