package com.example.backendcar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
@Getter
@Setter

@Entity
@Table(name = ("vehicle_images"))
public class VehicleImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = ("vehicle_id"), insertable = false, updatable = false)
    private Vehicle vehicle;
    @Column(name = ("vehicle_id"))
    private UUID vehicleId;

    @Column(name = ("is_default"))
    private Boolean isDefault;
    private Boolean status;
    private Integer position;
}