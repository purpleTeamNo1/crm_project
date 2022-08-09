package com.example.backend.service;

import com.example.backend.common.Result;
import com.example.backend.controller.DTO.InsuranceDTO;
import com.example.backend.entity.Insurance;

import java.util.List;

public interface InsuranceService {

    Result addInsurance(InsuranceDTO insuranceDTO);

    void deleteInsurance(int insuranceId);

    List<Insurance> findAllInsurance(int page, int size, String orderBy);

    Insurance findOneByPolicyNumber(String policyNumber);

    Insurance findOneByInsuranceId(int insuranceId);
}
