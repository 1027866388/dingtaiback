package com.dingtai.customermager.controller;

import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddContractPeriodReq;
import com.dingtai.customermager.entity.request.UpdateContractPeriodReq;
import com.dingtai.customermager.entity.response.GetContractPeriodResp;
import com.dingtai.customermager.service.ContractPeriodService;
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
@RequestMapping(value = "/contractPeriod")
@Api(description = "合同期间接口")
public class ContractPeriodController {

    @Autowired
    ContractPeriodService contractPeriodService;

    /**
     * 添加合同期间
     */
    @PostMapping("/addContractPeriod")
    @ApiOperation(value = "添加期间", httpMethod = "POST")
    public Result addContractPeriod(@RequestBody @Valid AddContractPeriodReq addContractPeriodReq) {
        contractPeriodService.addContractPeriod(addContractPeriodReq);
        return new Result();
    }

    /**
     * 删除期间
     *
     * @param id
     */
    @PostMapping("/deleteContract")
    @ApiOperation(value = "删除期间", httpMethod = "POST")
    public Result deleteContractPeriod(@ApiParam(name = "id", value = "主键id", required = true) @RequestParam Long id) {
        contractPeriodService.deleteContractPeriod(id);
        return new Result();
    }

    /**
     * 更新期间
     */
    @PostMapping("/updateContractPeriod")
    @ApiOperation(value = "更新期间", httpMethod = "POST")
    public Result updateContractPeriod(@RequestBody @Valid UpdateContractPeriodReq updateContractPeriodReq) {
        contractPeriodService.updateContractPeriod(updateContractPeriodReq);
        return new Result();
    }

    /**
     * 获取期间
     */
    @GetMapping("/getContractPeriod")
    @ApiOperation(value = "获取期间", httpMethod = "GET")
    public Result<GetContractPeriodResp> getContractPeriod(Long id) {
        GetContractPeriodResp data = contractPeriodService.getContractPeriod(id);
        return new Result<>(data);
    }


}
