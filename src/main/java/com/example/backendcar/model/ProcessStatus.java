package com.example.backendcar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = ("/proces_status"))
public class ProcessStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Auto
    private UUID id;

    private String name;
    @Column(name = "display_name")// default == name
    private String displayName;
}
