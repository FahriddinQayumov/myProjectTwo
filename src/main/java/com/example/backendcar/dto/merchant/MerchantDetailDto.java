package com.example.backendcar.dto.merchant;


import com.example.backendcar.enums.MerchantStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class MerchantDetailDto {

    private UUID id;
    private UUID userId;
    private String name;
    private String imageThumb;
    private Boolean isFeatured;
    private String phone;
    private String mobile;
    private String email;
    private String website;
    private String address;
    private String country;
    private MerchantStatus status;
    private LocalDateTime deletedAt;

}
