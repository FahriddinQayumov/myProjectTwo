package com.example.backendcar.dto.merchant;


import com.example.backendcar.enums.MerchantStatus;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class MerchantCreateDto {



    @NotBlank(message = "invalid name")
    private String name;
    private String imageThumb;
    private Boolean isFeatured;
    private String slug;
    @NotBlank(message = "invalid phone")
    private String phone;
    @NotBlank(message = "invalid mobile")
    private String mobile;
    @Email
    @NotBlank(message = "invalid email")
    private String email;
    private String website;
    @NotBlank(message = "invalid address")
    private String address;
    private String country;
    private MerchantStatus status;
    private LocalDateTime deletedAt;
}
