package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.GetCustomerListResp;
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
 *  @date 2020-02-20 15:40
 *  
 */
@RestController
@RequestMapping(value = "/customer")
@Api(description = "客户接口")
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    /**
     * 获取用户列表
     *
     * @param request 请求实体
     * @return Result实体
     */
    @GetMapping("/listCustomer")
    @ApiOperation(value = "获取客户列表", httpMethod = "GET")
    public Result<PageInfo<GetCustomerListResp>> listCustomer(GetCustomerListReq request) {
        DataValidator.isNull(request, "获取客户列表接口，请求参数不能为空！");

        PageInfo<GetCustomerListResp>data = customerService.listCustomer(request);
        Result result=new Result(data);
        return result;
    }
}