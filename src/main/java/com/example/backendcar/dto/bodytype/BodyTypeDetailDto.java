package com.example.backendcar.dto.bodytype;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class BodyTypeDetailDto {
    private UUID id;
    private String name;
    private Boolean status;
}
