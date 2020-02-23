package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.db.ContractEntity;
import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractInfoMapper {
    /**
     * 分页展示合同
     * @param request
     * @return
     */
    Page<GetContractListResp> listContract(GetContractListReq request);

    /**
     * 获取发票信息
     * @param contractId
     * @return
     */
    List<GetContractInvoiceResp> getContractInvoice(long contractId) ;

    /**
     * 获取期间信息
     * @param contractId
     * @return
     */
    List<GetContractPeriodResp> getContractPeriod(long contractId) ;

    /**
     * 获取收款信息
     * @param contractId
     * @return
     */
    List<GetContractReceivablesResp> getContractReceivables(long contractId) ;

    /**
     * 删除发票信息
     * @param contractId
     * @return
     */
    Long deleteInvoiceByContractId(@Param("contractId") Long contractId);

    /**
     * 删除收款信息
     * @param contractId
     * @return
     */
    Long deleteReceivablesByContractId(@Param("contractId") Long contractId);

    /**
     * 删除期间信息
     * @param contractId
     * @return
     */
    Long deletePeriodByContractId(@Param("contractId") Long contractId);

}