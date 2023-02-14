package com.example.backendcar.dto.user;

import com.example.backendcar.enums.UserStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
public class UserDetailedDto {
    private UUID id;
    private UUID userTypeId;
    private String username;
    private String password;
    private String email;
    private String token;
    private String firstName;
    private String lastName;
    private String avatar;
    private String phone;
    private LocalDate birth;
    private String address;
    private String address2;
    private Integer city;
    private String postcode;
    private String qrCode;
    private LocalDateTime createdAt;
    private Boolean enable;
}
