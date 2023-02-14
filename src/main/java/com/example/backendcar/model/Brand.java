package com.example.backendcar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
@Getter
@Setter

@Entity
@Table(name = ("brands"))
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String logo;
    private Boolean status;
}
