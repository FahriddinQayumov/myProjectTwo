package com.example.backendcar.model;


import com.example.backendcar.enums.MerchantStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity(name = "merchants")
@Table
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private UUID id;
    @Column(name = ("user_id"))
    private UUID userId;
    private String slug;
    private String name;
    @Column(name = ("image_thumb"))
    private String imageThumb;
    @Column(name = ("is_featured"))
    private Boolean isFeatured;
    private String phone;
    private String mobile;
    private String email;
    private String website;
    private String address;
    @Enumerated(EnumType.STRING)
    private String country;
    private MerchantStatus status;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
