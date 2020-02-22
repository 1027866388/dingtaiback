package com.dingtai.customermager.entity.db;

public class ProjectQuotationEntity {
    /**
     * 自增id
     */
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}