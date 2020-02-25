package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddContractPeriodReq;
import com.dingtai.customermager.service.ContractPeriodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-25 8:51
 *  
 */
@RestController
@RequestMapping(value = "/contractPeriod")
@Api(description = "合同期间接口")
public class ContractPeriodController {

    @Autowired
    ContractPeriodService contractPeriodService;
    /**
     * 添加合同期间
     */
    @PostMapping("/addContractPeriod")
    @ApiOperation(value = "添加合同期间", httpMethod = "POST")
    public Result addContractPeriod(AddContractPeriodReq addContractPeriodReq){
        contractPeriodService.addContractPeriod(addContractPeriodReq);
        return new Result();
    }
}
