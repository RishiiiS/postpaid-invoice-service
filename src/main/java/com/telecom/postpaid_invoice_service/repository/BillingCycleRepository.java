package com.telecom.postpaid_invoice_service.repository;

import com.telecom.postpaid_invoice_service.entity.BillingCycle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingCycleRepository extends JpaRepository<BillingCycle, String> {
}
