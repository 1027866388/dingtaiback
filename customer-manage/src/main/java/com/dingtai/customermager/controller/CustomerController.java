package com.dingtai.customermager.controller;

import com.dingtai.customermager.constants.DateTimeConstant;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.GetCustomerFollowResp;
import com.dingtai.customermager.entity.response.GetCustomerListResp;
import com.dingtai.customermager.service.CustomerService;
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

import java.util.List;

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
        PageInfo<GetCustomerListResp> data = customerService.listCustomer(request);
        Result result = new Result(data);
        return result;
    }

    /**
     * 获取客户的跟进信息
     *
     * @param customerId
     * @return
     */
    @GetMapping("/getCustomerFollow")
    @ApiOperation(value = "获取客户的跟进信息", httpMethod = "GET")
    public Result<List<GetCustomerFollowResp>> getCustomerFollow(@ApiParam(name = "customerId", value = "客户id", required = true) @RequestParam Long customerId) {
        List<GetCustomerFollowResp> data = customerService.getCustomerFollow(customerId);
        Result result = new Result(data);
        return result;
    }

    /**
     * 删除客户
     *
     * @param customerId
     * @return
     */
    @PostMapping("/deleteCustomer")
    @ApiOperation(value = "删除客户", httpMethod = "POST")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result<List<GetCustomerFollowResp>> deleteCustomer(@ApiParam(name = "customerId", value = "客户id", required = true) @RequestParam Long customerId) {
        customerService.deleteCustomer(customerId);
        Result result = new Result();
        return result;
    }

    /**
     * 获取客户
     *
     * @param id
     * @return
     */
    @PostMapping("/getCustomer")
    @ApiOperation(value = "获取客户", httpMethod = "POST")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result<List<GetCustomerFollowResp>> getCustomer(@ApiParam(name = "id", value = "id", required = true) @RequestParam Long id) {
        Result result = new Result();
        return result;
    }
}
