package com.mrkb.web.controller.weixin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.protocol.ProtocolEntity;
import com.mrkb.service.ProtocolService;

/**
 * @param
 * @return
 * @author moerka-1
 *
 */
@Controller("weixin/weixin_protocol")
@RequestMapping("/weixin/weixin_protocol")
public class ProtocolController {

	@Autowired
	private ProtocolService protocolService;

	/**
	 * 
	 * @Title: findAllProtocol @Description: TODO @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         vpi @throws
	 */
	@RequestMapping("findAllProtocol")
	public @ResponseBody ResponseData findAllProtocol(HttpServletResponse response, HttpServletRequest request) {
		ResponseData R = new ResponseData();
		ProtocolEntity pEntity = new ProtocolEntity();

		List<ProtocolEntity> pe = protocolService.findAllProtocol(pEntity);
		if (pe != null) {
			R.setData(pe);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 
	 * @Title: findProtocolById @Description: TODO @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         vpi @throws
	 */
	@RequestMapping("findProtocolById")
	public @ResponseBody ResponseData findProtocolById(HttpServletResponse response, HttpServletRequest request) {
		ResponseData R = new ResponseData();
		ProtocolEntity pEntity = new ProtocolEntity();
		try {
			Integer protocol_id = Integer.valueOf(request.getParameter("protocol_id"));
			pEntity.setProtocol_id(protocol_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		ProtocolEntity pe = protocolService.findProtocolById(pEntity);
		// System.out.println(pe);
		if (pe != null) {
			R.setData(pe);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setErrorCode(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

}
