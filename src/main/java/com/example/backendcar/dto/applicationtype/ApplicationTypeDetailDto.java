package com.example.backendcar.dto.applicationtype;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ApplicationTypeDetailDto {
    private UUID id;
    private String name;
    private String displayName;
    private String displayClass;
    private String displayIcon;
}
