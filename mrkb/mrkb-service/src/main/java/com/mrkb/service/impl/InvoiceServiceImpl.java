package com.mrkb.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mrkb.dao.dao.InvoiceMapper;
import com.mrkb.dao.modle.invoice.InvoiceEntity;
import com.mrkb.dao.modle.invoice.InvoiceGainEntity;
import com.mrkb.service.InvoiceService;

@Service
public class InvoiceServiceImpl implements InvoiceService{
	@Resource
	InvoiceMapper invoiceMapper;
    /**
     * 
     * <p>Title: addInvoice</p >添加一条用户索取发票的发票信息
     * <p>Description: </p >
     * @param invoiceEntity
     * @return
     * @see com.medicinefood.service.InvoiceService#addInvoice(com.medicinefood.entity.invoice.InvoiceEntity)
     */
	@Override
	public int addInvoice(InvoiceEntity invoiceEntity) {
		// TODO Auto-generated method stub
		invoiceEntity.setInvoice_status(1);
		invoiceMapper.insertInvoice(invoiceEntity);
		return invoiceEntity.getInvoice_id();
	}
    /**
     * 
     * <p>Title: findInvoiceToStatus</p >
     * <p>Description: </p > 根据收取发票信息的状态查询符合条件的数据
     * @param invoice_status
     * @return
     * @see com.medicinefood.service.InvoiceService#findInvoiceToStatus(int)
     */
	@Override
	public List<InvoiceEntity> findInvoiceToStatus(int invoice_status) {
		// TODO Auto-generated method stub
		return invoiceMapper.selectInvoiceTostatus(invoice_status);
	}
    /**
     * 
     * <p>Title: findInvoiceToUid</p >
     * <p>Description: </p > 通过用户id查询收取发票的信息
     * @param user_basics_id
     * @return
     * @see com.medicinefood.service.InvoiceService#findInvoiceToUid(int)
     */
	@Override
	public List<InvoiceEntity> findInvoiceToUid(int user_basics_id,int invoice_status) {//通过用户id查询收取发票的信息
		// TODO Auto-generated method stub
		return invoiceMapper.selectInvoiceToUid(user_basics_id,invoice_status);
	}
	/**
	 * 
	 * <p>Title: delInvoiceToInvoice_id</p >
	 * <p>Description: </p >通过收取发票信息id删除一条信息
	 * @param invoice_id
	 * @return
	 * @see com.medicinefood.service.InvoiceService#delInvoiceToInvoice_id(int)
	 */
	@Override
	public int delInvoiceToInvoice_id(int invoice_id) {//通过收取发票信息id删除一条信息
		// TODO Auto-generated method stub
		return invoiceMapper.deleteInvoiceToInvoice_id(invoice_id);
	}
	/**
	 * 
	 * <p>Title: addInvoiceGain</p >
	 * <p>Description: </p >用户索取发票，添加一条发票索取信息
	 * @param invoiceGainEntity
	 * @return
	 * @see com.medicinefood.service.InvoiceService#addInvoiceGain(com.medicinefood.entity.invoice.InvoiceGainEntity)
	 */
	@Override
	public int addInvoiceGain(int invoice_id) {
		// TODO Auto-generated method stub
		InvoiceGainEntity invoiceGainEntity=new InvoiceGainEntity();
		invoiceGainEntity.setInvoice_id(invoice_id);//发票收取信息id
		invoiceGainEntity.setAdd_date(new Date().getTime());//索取发票的时间
		invoiceGainEntity.setGain_status(1);//索取发票的状态 1显示中。2 已寄出。3删除
		invoiceMapper.insertInvoiceGain(invoiceGainEntity);//添加一条发票索取信息
		return invoiceGainEntity.getInvoice_gain_id();
	}
	
	
	/**
	 * 发票分页查询
	 */
	public List<InvoiceEntity> pageListInfo(Map<String, Object> param) {
		return invoiceMapper.pageListInfo(param);
	}
	

}
