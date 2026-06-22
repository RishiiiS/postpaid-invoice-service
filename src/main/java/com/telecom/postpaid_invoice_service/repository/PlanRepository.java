package com.telecom.postpaid_invoice_service.repository;

// import java.util.Optional;

import com.telecom.postpaid_invoice_service.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Integer> {


}
