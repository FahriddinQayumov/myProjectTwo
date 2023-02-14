package com.example.backendcar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter

@Entity
@Table(name = ("application_types"))
public class ApplicationType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Auto
    private UUID id;

    private String name;
    @Column(name = "display_name")// default  == name
    private String displayName;
    @Column(name = ("display_class"))
    private String displayClass;
    @Column(name = ("display_icon"))
    private String displayIcon;



}
