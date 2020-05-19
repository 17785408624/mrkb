package com.mrkb.service;

import java.util.List;
import java.util.Map;

import com.mrkb.dao.modle.invoice.InvoiceEntity;


public interface InvoiceService {
	/**
	 * 
	 * @Title:             addInvoice
	 * @Description:     TODO 添加一条用户索取发票的发票信息
	 * @param:             @param invoiceEntity 用户索取发票的发票信息
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int addInvoice(InvoiceEntity invoiceEntity);//添加一条用户索取发票的发票信息
	
	/**
	 * 
	 * @Title:             findInvoice
	 * @Description:     TODO 根据发票信息的状态查询符合条件的数据
	 * @param:             @param invoice_status  发票信息的状态
	 * @param:             @return   
	 * @return:         List<InvoiceEntity>   
	 * @throws
	 */
	List<InvoiceEntity>findInvoiceToStatus(int invoice_status);//根据收取发票信息的状态查询符合条件的数据
	/**
	 * 
	 * @Title:             findInvoiceToUid
	 * @Description:     TODO 通过用户id查询收取发票的信息
	 * @param:             @param user_basics_id 用户id
	 * @param:             @param invoice_status 索取发票的信息状态
	 * @param:             @return   
	 * @return:         List<InvoiceEntity>   
	 * @throws
	 */
	List<InvoiceEntity>findInvoiceToUid(int user_basics_id,int invoice_status);//通过用户id查询收取发票的信息
	/**
	 * 
	 * @Title:             delInvoiceToInvoice_id
	 * @Description:     TODO 通过收取发票信息id删除一条信息
	 * @param:             @param invoice_id 收取发票信息id
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int delInvoiceToInvoice_id(int invoice_id);//通过收取发票信息id删除一条信息
	int addInvoiceGain(int invoice_id);//用户索取发票，添加一条发票索取信息

	//发票分页查询
	List<InvoiceEntity> pageListInfo(Map<String, Object> param);

}
