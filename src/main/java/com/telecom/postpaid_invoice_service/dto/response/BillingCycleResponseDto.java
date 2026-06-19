package com.telecom.postpaid_invoice_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingCycleResponseDto {
    private String cycleCode;
    private LocalDate cycleStartDate;
    private LocalDate endDate;
    private LocalDate billingDate;
    private String remark;
    
}
