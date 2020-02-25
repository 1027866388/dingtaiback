package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddContractInvoiceReq;
import com.dingtai.customermager.entity.request.UpdateContractInvoiceReq;
import com.dingtai.customermager.entity.response.GetContractInvoiceResp;
import com.dingtai.customermager.service.ContractInvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    @ApiOperation(value = "添加发票", httpMethod = "POST")
    public Result addContractInvoice(@RequestBody @Valid AddContractInvoiceReq addContractInvoiceReq) {
        contractInvoiceService.addContractInvoice(addContractInvoiceReq);
        return new Result();
    }

    /**
     * 删除发票
     *
     * @param id
     */
    @PostMapping("/deleteContract")
    @ApiOperation(value = "删除发票", httpMethod = "POST")
    public Result deleteContractInvoice(@ApiParam(name = "id", value = "主键id", required = true) @RequestParam Long id) {
        contractInvoiceService.deleteContractInvoice(id);
        return new Result();
    }


    /**
     * 获取发票
     */
    @GetMapping("/getContractInvoice")
    @ApiOperation(value = "获取发票", httpMethod = "GET")
    public Result<GetContractInvoiceResp> getContractInvoice(Long id) {
        GetContractInvoiceResp data = contractInvoiceService.getContractInvoice(id);
        return new Result<>(data);
    }

    /**
     * 更新发票
     */
    @PostMapping("/updateContractInvoice")
    @ApiOperation(value = "更新发票", httpMethod = "POST")
    public Result updateContractInvoice(@RequestBody @Valid UpdateContractInvoiceReq updateContractInvoiceReq) {
        contractInvoiceService.updateContractInvoice(updateContractInvoiceReq);
        return new Result();
    }

}
