package com.example.backendcar.dto.apllication;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class ApplicationCreateDto {
@Min(1)
@Max(3)
    private UUID applicationTypeId;
    @NotBlank(message = ("invalid user id"))
    private UUID userId;
    @NotBlank(message = "invalid merchant id")
    private UUID merchanId;
    @NotBlank(message = ("invalid vehicle id"))
   private UUID vehicleId;
    @NotBlank(message = ("invalid price"))
    private Double price;
    private Integer conditionDurationType;
    private Integer conditionDuration;
    @NotBlank(message = ("invalid condition price"))
    private Double conditionPrice;
    @Min(0)
    @Max(2)
    @NotBlank(message = ("invalid proces status id"))
    private UUID processStatusId;

}
