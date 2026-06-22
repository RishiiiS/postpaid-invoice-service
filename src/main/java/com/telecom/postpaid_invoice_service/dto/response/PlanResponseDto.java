package com.telecom.postpaid_invoice_service.dto.response;

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
public class PlanResponseDto {
    private Integer planId;
    private String planName;
    private String planCode;
    private BigDecimal monthlyCharge;
    private String description;
    private Boolean isActive;
}
