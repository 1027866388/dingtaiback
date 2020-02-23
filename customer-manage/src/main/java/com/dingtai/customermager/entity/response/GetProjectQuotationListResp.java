package com.dingtai.customermager.entity.response;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 获取项目报价明细信息
 *
 * @author peng.lu
 * @date 2020/2/22
 */

public class GetProjectQuotationListResp implements Serializable {

    /**
     * 项目id
     */
    private Long id;

    /**
     * 报价id
     */
    private Long quotationId;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 内容
     */
    private String content;

    /**
     * 报价(单位：万元)
     */
    private Double quotation;


    /**
     * 备注
     */
    @ApiModelProperty(value = "备注", name = "remark", allowEmptyValue = true)
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(Long quotationId) {
        this.quotationId = quotationId;
    }

    @Override
    public String toString() {
        return "GetProjectQuotationListResp{" +
                "id=" + id +
                ", quotationId=" + quotationId +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", quotation=" + quotation +
                ", remark='" + remark + '\'' +
                '}';
    }
}
