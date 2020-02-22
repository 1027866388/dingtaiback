package com.dingtai.customermager.controller;

import com.dingtai.customermager.constants.DateTimeConstant;
import com.dingtai.customermager.entity.Result;
import com.dingtai.customermager.entity.request.AddQuotationReq;
import com.dingtai.customermager.service.ProjectQuotationService;
import com.dingtai.customermager.utils.DataValidator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * 报价模块接口
 *
 * @author peng.lu
 * @date 2020/2/22
 */

@RestController
@RequestMapping(value = "/quotation")
@Api(description = "报价接口")
public class ProjectQuotationController {

    @Autowired
    private ProjectQuotationService projectQuotationService;


    /**
     * 新增报价
     *
     * @param request 请求实体
     * @return Result实体
     */
    @PostMapping("/addQuotation")
    @ApiOperation(value = "新增报价", httpMethod = "POST")
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = DateTimeConstant.MINUTE_S, rollbackFor = Exception.class)
    public Result addQuotation(@RequestBody @Valid AddQuotationReq request) {

        DataValidator.isNull(request, "新增项目报价接口，请求参数不能为空！");
        return projectQuotationService.addQuotation(request);
    }
}
