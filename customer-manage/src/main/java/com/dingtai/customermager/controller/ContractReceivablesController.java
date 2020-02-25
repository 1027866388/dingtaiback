package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddContractReceivablesReq;
import com.dingtai.customermager.entity.request.UpdateContractReceivablesReq;
import com.dingtai.customermager.entity.response.GetContractReceivablesResp;
import com.dingtai.customermager.service.ContractReceivablesService;
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
    public Result addContractReceivables(@RequestBody @Valid AddContractReceivablesReq addContractReceivablesReq) {
        contractReceivablesService.addContractReceivables(addContractReceivablesReq);
        return new Result();
    }

    /**
     * 删除收款
     *
     * @param id
     */
    @PostMapping("/deleteContract")
    @ApiOperation(value = "删除收款", httpMethod = "POST")
    public Result deleteContractReceivables(@ApiParam(name = "id", value = "主键id", required = true) @RequestParam Long id) {
        contractReceivablesService.deleteContractReceivables(id);
        return new Result();
    }

    /**
     * 更新收款
     */
    @PostMapping("/updateContractReceivables")
    @ApiOperation(value = "更新收款", httpMethod = "POST")
    public Result updateContractReceivables(@RequestBody @Valid UpdateContractReceivablesReq updateContractReceivablesReq) {
        contractReceivablesService.updateContractReceivables(updateContractReceivablesReq);
        return new Result();
    }

    /**
     * 获取收款
     */
    @GetMapping("/getContractReceivables")
    @ApiOperation(value = "获取收款", httpMethod = "GET")
    public Result<GetContractReceivablesResp> getContractReceivables(Long id) {
        GetContractReceivablesResp data = contractReceivablesService.getContractReceivables(id);
        return new Result<>(data);
    }

}
