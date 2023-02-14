package com.example.backendcar.dto.processtatus;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class ProcesStatusDetailDto {
    private UUID id;
    @NotBlank(message = ("invalid name"))
    private String name;
    private String display_name;
}
