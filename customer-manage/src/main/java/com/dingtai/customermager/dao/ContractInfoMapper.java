package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.response.GetContractInvoiceResp;
import com.dingtai.customermager.entity.response.GetContractPeriodResp;
import com.dingtai.customermager.entity.response.GetContractReceivablesResp;
import com.dingtai.customermager.entity.response.GetContractResp;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractInfoMapper {
    /**
     * 分页展示合同
     *
     * @param request
     * @return
     */
    Page<GetContractResp> listContract(GetContractListReq request);

    /**
     * 获取发票信息
     *
     * @param contractId
     * @return
     */
    List<GetContractInvoiceResp> getContractInvoice(long contractId);

    /**
     * 获取期间信息
     *
     * @param contractId
     * @return
     */
    List<GetContractPeriodResp> getContractPeriod(long contractId);

    /**
     * 获取收款信息
     *
     * @param contractId
     * @return
     */
    List<GetContractReceivablesResp> getContractReceivables(long contractId);

    /**
     * 删除发票信息
     *
     * @param contractId
     * @return
     */
    Long deleteInvoiceByContractId(@Param("contractId") Long contractId);

    /**
     * 删除收款信息
     *
     * @param contractId
     * @return
     */
    Long deleteReceivablesByContractId(@Param("contractId") Long contractId);

    /**
     * 删除期间信息
     *
     * @param contractId
     * @return
     */
    Long deletePeriodByContractId(@Param("contractId") Long contractId);

}