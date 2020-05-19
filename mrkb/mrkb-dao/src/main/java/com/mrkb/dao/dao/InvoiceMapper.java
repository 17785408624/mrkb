package com.mrkb.dao.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.invoice.InvoiceEntity;
import com.mrkb.dao.modle.invoice.InvoiceGainEntity;

@Mapper
public interface InvoiceMapper{
	int insertInvoice(InvoiceEntity invoiceEntity);//插入一条用户收取发票的信息
	List<InvoiceEntity>selectInvoiceTostatus(int invoice_status);//通过收取发票的信息的状态来查询满足条件的信息
	List<InvoiceEntity>selectInvoiceToUid(
			@Param("user_basics_id")int user_basics_id,@Param("invoice_status")int invoice_status);//通过用户id查询收取发票的信息
	int insertInvoiceGain(InvoiceGainEntity invoiceGainEntity);//添加一条发票索取信息
    int deleteInvoiceToInvoice_id(int invoice_id);//通过收取发票信息id删除一条信息
	List<InvoiceEntity> pageListInfo(Map<String, Object> param);//分页查询发票
	int updateInvoice(InvoiceEntity invoiceEntity);//修改一条发票信息
	int updateInvoiceGain(InvoiceGainEntity invoiceGainEntity);//修改一条发票索取信息
}
