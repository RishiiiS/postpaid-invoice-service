package com.telecom.postpaid_invoice_service.service.impl;

import com.telecom.postpaid_invoice_service.dto.request.BillingCycleRequestDto;
import com.telecom.postpaid_invoice_service.dto.response.BillingCycleResponseDto;
import com.telecom.postpaid_invoice_service.entity.BillingCycle;
import com.telecom.postpaid_invoice_service.repository.BillingCycleRepository;
import com.telecom.postpaid_invoice_service.service.BillingCycleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BillingCycleServiceImpl implements BillingCycleService {

    private final BillingCycleRepository billingCycleRepository;

    @Override
    public List<BillingCycleResponseDto> getAllCycles() {
        return billingCycleRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public BillingCycleResponseDto getCycleByCode(String cycleCode) {
        BillingCycle billingCycle = billingCycleRepository.findById(cycleCode)
                .orElseThrow(() -> new RuntimeException("Billing cycle not found with code: " + cycleCode));
        return mapToResponseDto(billingCycle);
    }

    @Override
    public BillingCycleResponseDto createCycle(BillingCycleRequestDto requestDto) {
        // if (billingCycleRepository.existsById(requestDto.getCycleCode())) {
        //     throw new RuntimeException("Billing cycle already exists with code: " + requestDto.getCycleCode());
        // }

        BillingCycle entity = mapToEntity(requestDto);
        entity.setRemark(generateRemark(entity.getCycleCode()));
        BillingCycle savedEntity = billingCycleRepository.save(entity);

        return mapToResponseDto(savedEntity);
    }

    @Override
    public BillingCycleResponseDto updateCycle(String cycleCode, BillingCycleRequestDto requestDto) {
        BillingCycle existingCycle = billingCycleRepository.findById(cycleCode)
                .orElseThrow(() -> new RuntimeException("Billing cycle not found with code: " + cycleCode));

        existingCycle.setCycleStartDate(requestDto.getCycleStartDate());
        existingCycle.setEndDate(requestDto.getEndDate());
        existingCycle.setBillingDate(requestDto.getBillingDate());

        if (requestDto.getCycleCode() != null && !requestDto.getCycleCode().equals(existingCycle.getCycleCode())) {
            existingCycle.setCycleCode(requestDto.getCycleCode());
            existingCycle.setRemark(generateRemark(requestDto.getCycleCode()));
        }

        BillingCycle updatedEntity = billingCycleRepository.save(existingCycle);

        return mapToResponseDto(updatedEntity);
    }

    @Override
    public void deleteCycle(String cycleCode) {
        if (!billingCycleRepository.existsById(cycleCode)) {
            throw new RuntimeException("Billing cycle not found with code: " + cycleCode);
        }
        billingCycleRepository.deleteById(cycleCode);
    }
    private String generateRemark(String cycleCode) {
        if (cycleCode == null || !cycleCode.startsWith("m_")) {
            return null;
        }
        try {
            int day = Integer.parseInt(cycleCode.substring(2));
            return "Monthly " + day + getOrdinalSuffix(day) + " of every month";
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private String getOrdinalSuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:  return "st";
            case 2:  return "nd";
            case 3:  return "rd";
            default: return "th";
        }
    }

    private BillingCycleResponseDto mapToResponseDto(BillingCycle entity) {
        return BillingCycleResponseDto.builder()
                .cycleCode(entity.getCycleCode())
                .cycleStartDate(entity.getCycleStartDate())
                .endDate(entity.getEndDate())
                .billingDate(entity.getBillingDate())
                .remark(entity.getRemark())
                .build();
    }

    private BillingCycle mapToEntity(BillingCycleRequestDto dto) {
        return BillingCycle.builder()
                .cycleCode(dto.getCycleCode())
                .cycleStartDate(dto.getCycleStartDate())
                .endDate(dto.getEndDate())
                .billingDate(dto.getBillingDate())
                .build();
    }
}
