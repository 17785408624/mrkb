package com.mrkb.web.controller.sys;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.mrkb.dao.dao.InvoiceMapper;
import com.mrkb.dao.modle.invoice.InvoiceGainEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.invoice.InvoiceEntity;
import com.mrkb.service.InvoiceService;

@Controller
@RequestMapping("/admin_invoice")
public class InvoiceController {
	
	
	
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private InvoiceMapper invoiceMapper;
	
	/**
	 * 发票管理页面跳转
	 * @return
	 */
	@RequestMapping("/showAdminInvoice")
	public String showAdminInvoicePage(){
		return "sys/invoice/adminInvoice";
	}
	
	
	
	/**
	 * 后台管理发票列表查询
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/adminFindInvoicePageList")
	public ResponseData adminFindInvoicePageList(@RequestParam("pageIndex")Integer pageIndex,@RequestParam("pageSize") Integer pageSize,HttpServletRequest req){
		ResponseData R = new ResponseData();
		PageHelper.startPage(pageIndex, pageSize);
		List<InvoiceEntity> list = new ArrayList<InvoiceEntity>();
		String invoice_statusStr=req.getParameter("invoice_status");
//		int invoice_status=0;
//		if(invoice_statusStr != null){
//			invoice_status= Integer.parseInt(invoice_statusStr);
//		}else{
//			invoice_status=5;
//		}
		Map<String, Object>param = new HashMap<String, Object>();
		param.put("invoice_statusStr", invoice_statusStr);
		list=invoiceService.pageListInfo(param);
		PageInfo<InvoiceEntity> PageInfo = new PageInfo<>(list);
		R.setData(PageInfo);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		return R;
	}

	@ResponseBody
	@RequestMapping("/updateInvoice")
	public ResponseData updateMenu(@RequestBody InvoiceEntity invoiceEntity) {
		ResponseData R = new ResponseData();
		InvoiceGainEntity gainEntity  = new InvoiceGainEntity();
		invoiceEntity.setInvoice_status(2);//信息的状态，1显示中。2默认收票信息。3删除
		invoiceMapper.updateInvoice(invoiceEntity);
		gainEntity.setGain_status(2);//索取信息的状态，1显示中。2 已寄出。3删除
		gainEntity.setInvoice_id(invoiceEntity.getInvoice_id());
		Integer num = invoiceMapper.updateInvoiceGain(gainEntity);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

}
