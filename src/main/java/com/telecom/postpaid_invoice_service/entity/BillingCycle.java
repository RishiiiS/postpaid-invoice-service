package com.telecom.postpaid_invoice_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Represents a billing period in the Telecom Postpaid Invoicing System.
 * Acts as the root object for invoice processing.
 */
@Entity
@Table(name = "Billing_Cycle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillingCycle {
    
    @Id
    @Column(name = "cycle_code", nullable = false, length = 10)
    private String cycleCode;

    @Column(name = "cycle_start_date", nullable = false)
    private LocalDate cycleStartDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "billing_date", nullable = false)
    private LocalDate billingDate;

    @Column(name = "remark", length = 255)
    private String remark;

}
