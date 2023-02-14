package com.example.backendcar.model;

import com.example.backendcar.enums.Cities;
import com.example.backendcar.enums.UserRoles;
import com.example.backendcar.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "users")
@Table
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(name = ("user_type_id"))
    private UUID userTypeId;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private String token;
    @Column(name = ("first_name"))
    private String firstName;
    @Column(name = ("last_name"))
    private String lastName;
    private String avatar;
    @Column(unique = true)
    private String phone;
    private LocalDate birth;
    private String address;
    private String address2;
    private Integer city;
    private String postcode;
    @Column(name = ("qr_code"))
    private String qrCode;
    @Column(name = ("email_verified_at"))
    private LocalDateTime emailVerifiedAt;
    @Column(name = ("phone_verified_at"))
    private LocalDateTime phoneVerifiedAt;
    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
    @Column(name = ("update_at"))
    private LocalDateTime updatedAt;
    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
    private Boolean enable;
    private UserRoles role;

    @ManyToOne
    @JoinColumn(name = ("user_type_id"),updatable = false,insertable = false)
    UserType userType;
}
