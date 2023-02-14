package com.example.backendcar.model;

import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = ("applications"))
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//Auto
    private UUID id;
    @Column(name = ("user_id"))
    private UUID userId;
    @ManyToOne
    @JoinColumn(name = ("user_id"), insertable = false, updatable = false)//not null
    private User user;

    @Column(name = ("merchant_id"))
    private UUID merchantId;
    @ManyToOne
    @JoinColumn(name = ("merchant_id"),insertable = false,updatable = false)//not null
    private Merchant merchant;

    @Column(name = ("vehicle_id"))
    private UUID vehicle_id;
    @JoinColumn(name = ("vehicle_id"),insertable = false,updatable = false)//not null
    private Vehicle vehicle;
    @JsonRawValue
    @Column(name = ("vehicle_details"),columnDefinition = "json")
    private Vehicle vehicleDetails;

    private Double price;//not null

    @Column(name = ("condition_duration_type"))
    private Integer conditionDurationType;
    @Column(name = ("condition_duration"))

    private Integer conditionDuration;
    @Column(name = ("condition_price"))//not null

    private Double conditionPrice;
    @Column(name = ("process_status_id"))//1-> credit; 2->cash/payment: 3->deposit
    private ProcessStatus processStatus;
    @ManyToOne
    @JoinColumn(name = ("process_status_id"))//not null
    private  UUID procesStatusId;

    @Column(name = ("application_type_id"))// 0-> in process; 1-> copleted; 2-> rejected
    private ApplicationType applicationtype;
    @ManyToOne
    @JoinColumn(name = ("application_type_id"), insertable = false, updatable = false)
    private UUID applicationtypeId;


}
