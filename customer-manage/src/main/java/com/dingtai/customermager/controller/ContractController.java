package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.GetContractListResp;
import com.dingtai.customermager.entity.response.GetCustomerListResp;
import com.dingtai.customermager.service.ContractService;
import com.dingtai.customermager.service.CustomerService;
import com.dingtai.customermager.utils.DataValidator;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public Result<PageInfo<GetCustomerListResp>> listContract(GetContractListReq request) {
        DataValidator.isNull(request, "获取合同列表接口，请求参数不能为空！");

        PageInfo<GetContractListResp>data = contractService.listContract(request);
        Result result=new Result(data);
        return result;
    }

}
