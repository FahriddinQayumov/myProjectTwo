package com.example.backendcar.dto.model;

import com.example.backendcar.model.Brand;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class ModelCreateDto {
    @NotBlank(message = ("invalid name"))
    private String name;
    private Boolean status;
    private UUID brandId;
}
