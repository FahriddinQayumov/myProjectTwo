package com.example.backendcar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "user_types")
@Table
@Getter
@Setter
public class UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    String name;
    @Column(name = ("display_name"))
    String displayName;
    Boolean status;
}
