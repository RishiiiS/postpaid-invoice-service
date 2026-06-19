package com.telecom.postpaid_invoice_service.service;

import com.telecom.postpaid_invoice_service.dto.request.BillingCycleRequestDto;
import com.telecom.postpaid_invoice_service.dto.response.BillingCycleResponseDto;

import java.util.List;

public interface BillingCycleService {

    List<BillingCycleResponseDto> getAllCycles();

    BillingCycleResponseDto getCycleByCode(String cycleCode);

    BillingCycleResponseDto createCycle(BillingCycleRequestDto requestDto);

    BillingCycleResponseDto updateCycle(String cycleCode, BillingCycleRequestDto requestDto);

    void deleteCycle(String cycleCode);

}
