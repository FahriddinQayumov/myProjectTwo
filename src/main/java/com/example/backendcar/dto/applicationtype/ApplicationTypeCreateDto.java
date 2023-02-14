package com.example.backendcar.dto.applicationtype;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ApplicationTypeCreateDto {
    @NotBlank(message = ("Invalid name"))
    String name;
    String displayName;
    String displayClass;
    String displayIcon;
}
