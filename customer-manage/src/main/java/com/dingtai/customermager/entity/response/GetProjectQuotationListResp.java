package com.dingtai.customermager.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 获取项目报价明细信息
 *
 * @author peng.lu
 * @date 2020/2/22
 */
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class GetProjectQuotationListResp implements Serializable {

    /**
     * 项目id
     */
    private Long id;

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

    @Override
    public String toString() {
        return "GetProjectQuotationListResp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", quotation=" + quotation +
                ", remark='" + remark + '\'' +
                '}';
    }
}
