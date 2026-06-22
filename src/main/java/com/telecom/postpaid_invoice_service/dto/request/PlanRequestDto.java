package com.telecom.postpaid_invoice_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanRequestDto {

    @NotBlank(message = "Plan name is required")
    private String planName;

    @NotBlank(message = "Plan code is required")
    private String planCode;

    @NotNull(message = "Monthly charge is required")
    @Positive(message = "Monthly charge must be positive")
    private BigDecimal monthlyCharge;

    private String description;
    
    @NotNull(message = "Active status is required")
    private Boolean isActive;
}
