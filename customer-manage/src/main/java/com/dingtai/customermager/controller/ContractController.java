package com.dingtai.customermager.controller;

import com.dingtai.customermager.constants.DateTimeConstant;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddContractReq;
import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.request.UpdateContractReq;
import com.dingtai.customermager.entity.response.*;
import com.dingtai.customermager.service.ContractService;
import com.dingtai.customermager.utils.DataValidator;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-21 14:33
 *  
 */
@RestController
@RequestMapping(value = "/contract")
@Api(description = "合同接口")
public class ContractController {
    @Autowired
    private ContractService contractService;

    /**
     * 获取用户列表
     *
     * @param request 请求实体
     * @return Result实体
     */
    @GetMapping("/listContract")
    @ApiOperation(value = "获取合同列表", httpMethod = "GET")
    public Result<PageInfo<GetContractResp>> listContract(GetContractListReq request) {
        DataValidator.isNull(request, "获取合同列表接口，请求参数不能为空！");

        PageInfo<GetContractResp> data = contractService.listContract(request);
        Result result = new Result(data);
        return result;
    }

    /**
     * 获取合同的期间信息
     *
     * @param customerId
     * @return
     */
    @GetMapping("/getContractPeriod")
    @ApiOperation(value = "获取合同的期间信息", httpMethod = "GET")
    public Result<List<GetCustomerFollowResp>> getContractPeriod(@ApiParam(name = "customerId", value = "客户id", required = true) @RequestParam Long customerId) {
        List<GetContractPeriodResp> data = contractService.getContractPeriod(customerId);
        Result result = new Result(data);
        return result;
    }

    /**
     * 获取合同的收款信息
     *
     * @param customerId
     * @return
     */
    @GetMapping("/getContractReceivables")
    @ApiOperation(value = "获取合同的收款信息", httpMethod = "GET")
    public Result<List<GetContractReceivablesResp>> getContractReceivables(@ApiParam(name = "customerId", value = "客户id", required = true) @RequestParam Long customerId) {
        List<GetContractReceivablesResp> data = contractService.getContractReceivables(customerId);
        Result result = new Result(data);
        return result;
    }

    /**
     * 获取合同的发票信息
     *
     * @param customerId
     * @return
     */
    @GetMapping("/getContractInvoice")
    @ApiOperation(value = "获取合同的发票信息", httpMethod = "GET")
    public Result<List<GetContractInvoiceResp>> getContractInvoice(@ApiParam(name = "customerId", value = "客户id", required = true) @RequestParam Long customerId) {
        List<GetContractInvoiceResp> data = contractService.getContractInvoice(customerId);
        Result result = new Result(data);
        return result;
    }

    /**
     * 删除合同
     *
     * @param contractId 用户id
     * @return Result实体
     */
    @PostMapping("/deleteContract")
    @ApiOperation(value = "删除合同", httpMethod = "POST")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result deleteUser(@ApiParam(name = "contractId", value = "合同id", required = true) @RequestParam Long contractId) {
        ;

        contractService.deleteContract(contractId);
        return new Result();
    }

    /**
     * 添加合同
     *
     * @param addContractReq
     * @return
     */
    @PostMapping("/addContract")
    @ApiOperation(value = "添加合同", httpMethod = "POST")
    public Result addContract(@RequestBody @Valid AddContractReq addContractReq) {
        contractService.addContract(addContractReq);
        return new Result();
    }

    /**
     * 更新合同基本信息
     *
     * @param updateContractReq
     */
    @PostMapping("/updateContract")
    @ApiOperation(value = "更新合同基本信息", httpMethod = "POST")
    public Result updateContract(@RequestBody @Valid UpdateContractReq updateContractReq) {
        contractService.updateContract(updateContractReq);
        return new Result();
    }


    /**
     * 获取合同基本信息
     *
     * @param id
     * @return
     */
    @GetMapping("/getContract")
    @ApiOperation(value = "获取合同基本信息", httpMethod = "GET")
    public Result<GetContractResp> getContract(@ApiParam(name = "id", value = "主键id", required = true) @RequestParam Long id) {
        GetContractResp data = contractService.getContract(id);
        return new Result<>(data);
    }


}
