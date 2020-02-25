package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddContractInvoiceReq;
import com.dingtai.customermager.service.ContractInvoiceService;
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
 *  @date 2020-02-25 8:41
 *  
 */
@RestController
@RequestMapping(value = "/contractInvoice")
@Api(description = "合同发票接口")
public class ContractInvoiceController {

    @Autowired
    ContractInvoiceService contractInvoiceService;
    /**
     * 添加合同发票
     */
    @PostMapping("/addContractInvoice")
    @ApiOperation(value = "添加合同发票", httpMethod = "POST")
    public Result addContractInvoice(AddContractInvoiceReq addContractInvoiceReq)
    {
        contractInvoiceService.addContractInvoice(addContractInvoiceReq);
        return new Result();
    }
}
