package com.example.backend.controller.DTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@ApiModel
public class InsuranceDTO {

    @ApiModelProperty(name = "productId", required = true)
    private int productId;

    @ApiModelProperty(name = "productCode", required = true)
    private String productCode;

    @ApiModelProperty(name = "insuranceId", required = true)
    private int insuranceId;

    private String policyNumber;

    private String applicationNumber;

    private Date applicationDate;

    @ApiModelProperty(name = "coi", dataType = "Decimal", example = "123.32")
    private double coi;

    @ApiModelProperty(name = "enforcementDate", dataType = "Date", example = "2022-08-09")
    private Date enforcementDate;

    @ApiModelProperty(name = "maturityDate", dataType = "Date", example = "2022-08-09")
    private Date maturityDate;

    @ApiModelProperty(name = "coverageAmount", dataType = "Decimal", example = "123.32")
    private double coverageAmount;

    @ApiModelProperty(name = "additionalDeposit", dataType = "Decimal", example = "123.32")
    private double additionalDeposit;

    private int paymentTime;

    private String riders;

    private String province;

    private String note;
}
