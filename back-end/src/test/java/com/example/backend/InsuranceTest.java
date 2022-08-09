package com.example.backend;

import com.example.backend.entity.Insurance;
import com.example.backend.repository.InsuranceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceRepository insuranceRepository;
    @Test
    public void findByPolicyNumberTest(){
        Insurance result = insuranceRepository.findByPolicyNumber("A8785");
        System.out.println(result);
        System.out.println(result.getProduct());
    }
}
