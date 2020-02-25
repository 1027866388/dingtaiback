package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddContractReceivablesReq;
import com.dingtai.customermager.service.ContractReceivablesService;
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
@RequestMapping(value = "/contractReceivables")
@Api(description = "合同收款接口")
public class ContractReceivablesController {

    @Autowired
    ContractReceivablesService contractReceivablesService;
    /**
     * 添加合同收款
     */
    @PostMapping("/addContractReceivables")
    @ApiOperation(value = "添加合同收款", httpMethod = "POST")
    public Result addContractReceivables(AddContractReceivablesReq addContractReceivablesReq){
        contractReceivablesService.addContractReceivables(addContractReceivablesReq);
        return new Result();
    }
}
