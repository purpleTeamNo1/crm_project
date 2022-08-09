package com.example.backend.repository;

import com.example.backend.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

    Insurance findByPolicyNumber(String policyNumber);

    Insurance findByInsuranceId(int insuranceId);
}
