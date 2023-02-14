package com.example.backendcar.dto.processtatus;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Getter
@Setter
public class ProcesStatusCreateDto {
    @NotBlank(message = ("invalid_name"))
    private String name;
    private String display_name;
}
