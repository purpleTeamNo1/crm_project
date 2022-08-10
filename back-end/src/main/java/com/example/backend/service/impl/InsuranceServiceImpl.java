package com.example.backend.service.impl;

import com.example.backend.common.Result;
import com.example.backend.controller.DTO.InsuranceDTO;
import com.example.backend.entity.Insurance;
import com.example.backend.entity.Product;
import com.example.backend.repository.InsuranceRepository;
import com.example.backend.repository.ProductRepository;
import com.example.backend.service.InsuranceService;
import com.example.backend.utils.DateAndTimeUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    @Autowired
    InsuranceRepository insuranceRepository;

    @Autowired
    ProductRepository productRepository;

    //1. Add Product and Insurance
    public Result addInsurance(InsuranceDTO insuranceDTO){
        Insurance insurance = new Insurance();
        Product product = new Product();

        BeanUtils.copyProperties(insuranceDTO, insurance);
        insurance.setLastUpdate(DateAndTimeUtils.getCurrentTime());
        BeanUtils.copyProperties(insuranceDTO,product);
        product.setLastUpdate(DateAndTimeUtils.getCurrentTime());

        try{
            productRepository.save(product);
            insuranceRepository.save(insurance);
        }catch (Exception e){
            Result.error("600",e.getMessage());
        }
        return Result.success("New insurance product has been added.");
    }

    //2. delete Insurance
    public void deleteInsurance(int insuranceId){
        insuranceRepository.deleteById(insuranceId);
    }

    //3. update Insurance with same addInsurance method

    //4. query Insurance and product
    //4.1 query all insurance product paginate and order by given condition
    public List<Insurance> findAllInsurance(int page, int size, String orderBy){
        List insurances = insuranceRepository.findAll(PageRequest.of(page,size, Sort.by(orderBy).ascending())).get().toList();
//        List allTodos = todosRepository.findAllByOrderByIdAsc(PageRequest.of(page,size));
        return insurances;
    }

    //4.2 query insurance product by policyNumber
    public Insurance findOneByPolicyNumber(String policyNumber){
        return insuranceRepository.findByPolicyNumber(policyNumber);
    }

    //4.3 query insurance product by insuranceid
    public Insurance findOneByInsuranceId(int insuranceId){
        return insuranceRepository.findByInsuranceId(insuranceId);
    }


}
