package com.example.backendcar.dto.vehicleimage;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class VehicleImageDetailDto {
    private UUID id;
    private UUID vehicleId;
    private Boolean isDefault;
    private Boolean status;
    private Integer position;
}
