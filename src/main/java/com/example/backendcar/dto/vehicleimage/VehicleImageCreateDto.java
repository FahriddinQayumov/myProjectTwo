package com.example.backendcar.dto.vehicleimage;

import com.example.backendcar.model.Vehicle;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.UUID;

@Getter
@Setter
public class VehicleImageCreateDto {
    private UUID vehicleId;
    private Boolean isDefault;
    private Boolean status;
    private Integer position;
}
