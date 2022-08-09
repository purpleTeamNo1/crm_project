package com.example.backend.controller;

import com.example.backend.controller.DTO.ClientDTO;
import com.example.backend.controller.DTO.InsuranceDTO;
import com.example.backend.controller.DTO.QueryClientDTO;
import com.example.backend.entity.Client;
import com.example.backend.entity.Insurance;
import com.example.backend.entity.Product;
import com.example.backend.repository.InsuranceRepository;
import com.example.backend.service.InsuranceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/insurance")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

    @ApiOperation("add insurance product")
    @PostMapping("/add")
    public void addInsurance(@RequestBody InsuranceDTO insuranceDTO){
        insuranceService.addInsurance(insuranceDTO);
    }

    @ApiOperation("update current insurance product")
    @PostMapping("/update")
    public void updateInsurance(@RequestBody InsuranceDTO insuranceDTO){
        insuranceService.addInsurance(insuranceDTO);
    }

    @ApiOperation("delete current insurance product")
    @GetMapping("/delete")
    public void deleteInsurance(@RequestParam int insuranceId){
        insuranceService.deleteInsurance(insuranceId);
    }


    @ApiOperation("find all insurance product")
    @GetMapping("/findall")
    @ApiImplicitParams({@ApiImplicitParam(name = "page", required = true, paramType = "query", dataType = "Integer", defaultValue = "0"),
                        @ApiImplicitParam(name = "size", required = true, paramType = "query", dataType = "Integer", defaultValue = "10"),
                        @ApiImplicitParam(name = "orderBy", value = "please choose from insuranceId, policyNumber, applicationNumber, " +
                                "applicationDate", required = true, paramType = "query", dataType = "String", defaultValue = "insuranceId")})
    public List<Product> findAll(@RequestParam int page,
                                   @RequestParam int size,
                                   @RequestParam String orderBy){
        List<Insurance> insurances = insuranceService.findAllInsurance(page,size,orderBy);
        List<Product> products = new ArrayList<>();
        for (Insurance element:insurances) {
            products.add(element.getProduct());
        }
        return products;
    }

    @ApiOperation("find one insurance product by insurance id")
    @GetMapping("/findbyid")
    public Product findByInsuranceId(@RequestParam int insuranceId){
        return insuranceService.findOneByInsuranceId(insuranceId).getProduct();
    }

    @ApiOperation("find one insurance product by policy number")
    @GetMapping("/findbypolicynumber")
    public Product findByPolicyNumber(@RequestParam String policyNumber){
        return insuranceService.findOneByPolicyNumber(policyNumber).getProduct();
    }
}
