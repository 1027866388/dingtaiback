package com.dingtai.customermager.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;

/**
 * 新增报价请求实体
 *
 * @author peng.lu
 * @date 2020/2/22
 */
@ApiModel(value = "AddQuotationReq", description = "添加报价请求实体")
public class AddQuotationReq {

    /**
     * 报价内容
     */
    @ApiModelProperty(value = "报价内容", name = "content", required = true)
    @NotBlank(message = "报价内容不能为空")
    private String content;

    /**
     * 报价金额
     */
    @ApiModelProperty(value = "报价金额", name = "quotation", required = true)
    private Double quotation;

    /**
     * 对应项目
     */
    @ApiModelProperty(value = "对应项目名称", name = "name", required = true)
    private String projectName;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "remark", required = false)
    private String remark;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getQuotation() {
        return quotation;
    }

    public void setQuotation(Double quotation) {
        this.quotation = quotation;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
