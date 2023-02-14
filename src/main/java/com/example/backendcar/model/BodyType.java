package com.example.backendcar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
@Getter
@Setter

@Entity
@Table(name = ("body_types"))
public class BodyType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private Boolean status;
}
