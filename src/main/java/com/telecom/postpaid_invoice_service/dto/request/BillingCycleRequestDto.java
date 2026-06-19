package com.telecom.postpaid_invoice_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class BillingCycleRequestDto {

    @NotBlank(message = "Cycle code is required")
    @Size(max = 10, message = "Cycle code cannot exceed 10 characters")
    private String cycleCode;

    @NotNull(message = "Cycle start date is required")
    private LocalDate cycleStartDate;

    @NotNull(message = "End date is required")
    private LocalDate endDate;

    @NotNull(message = "Billing date is required")
    private LocalDate billingDate;

    private String remark;

}
