package com.mrkb.web.controller.sys;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.protocol.ProtocolEntity;
import com.mrkb.service.ProtocolService;

/**
 * 协议管理
 * @author ly
 *
 */
@Controller
@RequestMapping("/admin_protocol")
public class ProtocolController {
	@Autowired
	private ProtocolService protocolService;
	/**
	 * 协议管理跳转页面
	 * 
	 * @return 跳转/sys/protocolManage.html
	 */
	@RequestMapping("/protocolManage")
	public String protocolManage() {
		return "sys/protocol/protocolManage";
	}
	/**
	 * 
	 * @Title:             getByProtocolId
	 * @Description:     TODO 查询单个协议
	 * @param:             @param id
	 * @param:             @return   R
	 * @return:            
	 * @throws
	 */
	
	@RequestMapping("getByProtocolId/{id}")
	public @ResponseBody ResponseData getByProtocolId(@PathVariable("id") Integer id){
	    ProtocolEntity  pEntity  =new ProtocolEntity();
	    ResponseData R = new ResponseData();
		pEntity.setProtocol_id(id);
		ProtocolEntity pe=protocolService.findProtocolById(pEntity);
		if (pe != null) {
			R.setData(pe);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	/**
	 * 
	 * @Title:             protocolAdd
	 * @Description:     TODO 新增协议
	 * @param:             @param ProtocolEntity
	 * @param:             @return   
	 * @return:            r
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("/protocolAdd")
	public  ResponseData protocolAdd(@RequestBody ProtocolEntity protocolEntity){
		ResponseData r = new ResponseData();
		protocolEntity.setStatus_state(1);//新增协议审核状态默认为1
		protocolEntity.setAdd_date(System.currentTimeMillis());
		ProtocolEntity addProtocolEntity=protocolService.addProtocol(protocolEntity);
		if (addProtocolEntity != null) {
			
			r.setErrorCode(ResponseCode.SUCC_DO.getCode());
			r.setMessage(ResponseCode.SUCC_DO.getMsg());
			return r;
		}
		r.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		r.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return r;
	}
	/**
	 * 修改协议信息
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editProtocol")
	public ResponseData editProtocol(@RequestBody ProtocolEntity protocolEntity) {
		ResponseData R = new ResponseData();
		Integer num = protocolService.updateProtocol(protocolEntity);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	/*
	 * 删除协议信息
	 */
	@ResponseBody
	@RequestMapping("/deleteProtocol/{id}")
	public ResponseData deleteProtocol(@PathVariable("id") Integer id,HttpServletRequest request){
		ResponseData R = new ResponseData();
		ProtocolEntity pEntity = new ProtocolEntity();
		pEntity.setProtocol_id(id);
		int num = protocolService.deleteProtocol(pEntity);//删除协议
		if(num>0){
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
	
	/**
	 * 协议管理列表信息展示
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/protocolList/{pageNum}/{pageSize}")
	public ResponseData protocolList(@PathVariable("pageNum") Integer pageNum, @PathVariable("pageSize") Integer pageSize,
			HttpServletRequest req) {
		ResponseData R = new ResponseData();
		ProtocolEntity pEntity = new ProtocolEntity();
		pEntity.setStatus_state(0);
		String protocol_title = req.getParameter("name");//根据协议标题查询数据
		pEntity.setProtocol_title(protocol_title);
		PageHelper.startPage(pageNum, pageSize);
		List<ProtocolEntity> protocolList = protocolService.findAllProtocol(pEntity);//查询协议列表
		PageInfo<ProtocolEntity> PageInfo = new PageInfo<>(protocolList);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(PageInfo);
		return R;
	}

}
