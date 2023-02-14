package com.example.backendcar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;
@Getter
@Setter

@Entity
@Table(name = ("vehicles"))
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = ("merchant_id"))
    private Merchant merchant;
    @Column(name = ("merchant_id"))
    private UUID merchantId;

    @ManyToOne
    @JoinColumn(name = ("brand_id"),insertable = false,updatable = false)
    private Brand brand;
    @Column(name = ("brand_id"))
    private UUID brandId;

    @ManyToOne
    @JoinColumn(name = ("model_id"),insertable = false,updatable = false)
    private Model model;
    @Column(name = ("model_id"))
    private UUID modelId;

    @ManyToOne
    @JoinColumn(name = ("body_type_id"),insertable = false,updatable = false)
    private BodyType bodyType;
    @Column(name = ("body_type_id"))
    private UUID bodyTypeId;

    private String name;
    private Integer year;
    private String color;
    @Column(name = ("number_sits"))
    private Integer numberSits;
    @Column(name = ("is_new"))
    private Boolean isNew;
    private Double price;
    @Column(name = ("condition_duration_type"))
    private Integer conditionDurationType;
    @Column(name = ("condition_duration"))
    private Integer conditionDuration;
    @Column(name = ("condition_price"))
    private Double conditionPrice;
    private Boolean status;
}
