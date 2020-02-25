package com.dingtai.customermager.entity.request;

/**
 * 获取项目报价列表请求实体
 *
 * @author peng.lu
 * @date 2020/2/22
 */
public class GetProjectQuotationListReq extends BasePageReq{

    /**
     * 内容
     */
    private String content;

    /**
     * 报价(单位：万元)
     */
    private Double quotation;

    /**
     * 关联的项目
     */
    private Long project;

    /**
     * 备注
     */
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

    public Long getProject() {
        return project;
    }

    public void setProject(Long project) {
        this.project = project;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "GetProjectQuotationListReq{" +
                "content='" + content + '\'' +
                ", quotation=" + quotation +
                ", project=" + project +
                ", remark='" + remark + '\'' +
                '}';
    }
}
