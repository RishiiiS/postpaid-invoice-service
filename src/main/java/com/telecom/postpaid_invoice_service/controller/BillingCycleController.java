package com.telecom.postpaid_invoice_service.controller;

import com.telecom.postpaid_invoice_service.dto.request.BillingCycleRequestDto;
import com.telecom.postpaid_invoice_service.dto.response.BillingCycleResponseDto;
import com.telecom.postpaid_invoice_service.service.BillingCycleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cycles")
@RequiredArgsConstructor
public class BillingCycleController {

    private final BillingCycleService billingCycleService;

    @GetMapping
    public ResponseEntity<List<BillingCycleResponseDto>> getAllCycles() {
        return ResponseEntity.ok(billingCycleService.getAllCycles());
    }

    @GetMapping("/{cycleCode}")
    public ResponseEntity<BillingCycleResponseDto> getCycleByCode(@PathVariable String cycleCode) {
        return ResponseEntity.ok(billingCycleService.getCycleByCode(cycleCode));
    }

    @PostMapping
    public ResponseEntity<BillingCycleResponseDto> createCycle(@Valid @RequestBody BillingCycleRequestDto requestDto) {
        BillingCycleResponseDto createdCycle = billingCycleService.createCycle(requestDto);
        return new ResponseEntity<>(createdCycle, HttpStatus.CREATED);
    }

    @PutMapping("/{cycleCode}")
    public ResponseEntity<BillingCycleResponseDto> updateCycle(
            @PathVariable String cycleCode,
            @Valid @RequestBody BillingCycleRequestDto requestDto) {
        return ResponseEntity.ok(billingCycleService.updateCycle(cycleCode, requestDto));
    }

    @DeleteMapping("/{cycleCode}")
    public ResponseEntity<Void> deleteCycle(@PathVariable String cycleCode) {
        billingCycleService.deleteCycle(cycleCode);
        return ResponseEntity.noContent().build();
    }
}
