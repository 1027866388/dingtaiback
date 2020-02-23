package com.dingtai.customermager.dao;

import com.dingtai.customermager.entity.db.ContractEntity;
import com.dingtai.customermager.entity.request.GetContractListReq;
import com.dingtai.customermager.entity.request.GetCustomerListReq;
import com.dingtai.customermager.entity.response.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContractInfoMapper {
    Page<GetContractListResp> listContract(GetContractListReq request);

    List<GetContractInvoiceResp> getContractInvoice(long contractId) ;

    List<GetContractPeriodResp> getContractPeriod(long contractId) ;

    List<GetContractReceivablesResp> getContractReceivables(long contractId) ;
}