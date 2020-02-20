package com.dingtai.customermager.entity.response;

import io.swagger.annotations.ApiModelProperty;

/**
 *  TODO
 *  
 *  @author wangyanhui
 *  @date 2020-02-20 16:18
 *  
 */
public class GetCustomerResp {
    /**
     * 主键id
     */
    @ApiModelProperty(value = "主键id", name = "id")
    private Long id;

    /**
     * 供应商名称
     */
    @ApiModelProperty(value = "供应商名称", name = "customerName")
    private String customerName;

    /**
     * 联系人
     */
    @ApiModelProperty(value = "联系人", name = "contacts")
    private String contacts;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码", name = "phone")
    private String phone;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址", name = "address")
    private String address;

    /**
     * 开户名
     */
    @ApiModelProperty(value = "用户id", name = "bankName")
    private String bankName;

    /**
     * 统一社会信用码
     */
    @ApiModelProperty(value = "统一社会信用码", name = "creditCode")
    private String creditCode;

    /**
     * 开户行
     */
    @ApiModelProperty(value = "开户行", name = "bank")
    private String bank;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话", name = "tel")
    private String tel;

    /**
     * 发票内容
     */
    @ApiModelProperty(value = "用户id", name = "invoiceContent")
    private String invoiceContent;

    /**
     * 发票类型
     */
    @ApiModelProperty(value = "发票类型", name = "invoiceType")
    private String invoiceType;

    /**
     * 账户
     */
    @ApiModelProperty(value = "账户", name = "account")
    private String account;

    /**
     * 注册地址
     */
    @ApiModelProperty(value = "注册地址", name = "registerAddress")
    private String registerAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getInvoiceContent() {
        return invoiceContent;
    }

    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent;
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(String invoiceType) {
        this.invoiceType = invoiceType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getRegisterAddress() {
        return registerAddress;
    }

    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

}
