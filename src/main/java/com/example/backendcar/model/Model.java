package com.example.backendcar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
@Getter
@Setter

@Entity
@Table(name = ("models"))
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Boolean status;
    @ManyToOne
    @JoinColumn(name = ("brand_id"),insertable = false,updatable = false)
    private Brand brand;
    @Column(name = ("brand_id"))
    private UUID brandId;
}
