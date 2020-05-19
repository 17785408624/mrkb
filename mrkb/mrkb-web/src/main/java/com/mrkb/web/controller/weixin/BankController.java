
package com.mrkb.web.controller.weixin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.shiro.session.SessionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseData;
import com.mrkb.dao.modle.bank.BankEntity;
import com.mrkb.service.BankService;
import com.mrkb.shiro.cookieutil.SessionEntity;

/**
 *@param
 *@return
 * @author liangyi
 *
 */
@Controller("weixin/weixin_bank")
@RequestMapping("/weixin/weixin_bank")
public class BankController {

	@Autowired
	private BankService bankService;
	
	/**
	 * 
	 * @Title:             findAllBank
	 * @Description:     TODO 查看银行卡信息
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:            vbl 
	 * @throws
	 */
	@RequestMapping("findAllBank")
	public @ResponseBody ResponseData findAllBank(HttpServletResponse response,HttpServletRequest request){
		ResponseData rs = new ResponseData();
		BankEntity bEntity= new BankEntity();
		Integer user_basics_id =-1;
		SessionEntity se = null;
		try {
			se = new SessionEntity(request);
			user_basics_id =se.getUser_basics_id();
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			rs.setMessage("获取cookie信息失败！");
			return rs;
		}
		bEntity.setUser_basics_id(user_basics_id);
		List<BankEntity> be=bankService.findAllBank(bEntity);
		if( be!=null){
			rs.setData(be);
			rs.setIsSuccess(true);
		}else{
			rs.setIsSuccess(false);
			
		}
		
		//System.vbl.println("vpi的值："+vpi);
		return rs;
	}
	
	/**
	 * 
	 * @Title:             findBankById
	 * @Description:     TODO 查看单个银行卡信息详情
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:            vbl
	 * @throws
	 */
	@RequestMapping("findBankById")
	public @ResponseBody ResponseData findBankById(HttpServletResponse response,HttpServletRequest request ){
		ResponseData rs = new ResponseData();
		BankEntity bEntity= new BankEntity();
		Integer card_id =0;
		 try {
		   card_id =Integer.valueOf(request.getParameter("card_id"));
		   bEntity.setCard_id(card_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		BankEntity be = bankService.findBanklById(bEntity);
		//System.out.println(be);
		 if(be!=null){
			 rs.setData(be);
			 
			 rs.setMessage("查询成功");
			 rs.setIsSuccess(true);
		 }else{
			 rs.setIsSuccess(false);
			 rs.setMessage("查询失败");
		 }
		
		return rs;
	}
	/**
	 * 
	 * @Title:             addBank
	 * @Description:     TODO 新增银行卡
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:            vbl
	 * @throws
	 */
	@RequestMapping("addBank")
	public @ResponseBody ResponseData addBank(HttpServletResponse response,HttpServletRequest request ){
		ResponseData rs = new ResponseData();
		BankEntity bEntity  = new BankEntity();
		SessionEntity se = null;
		/*通过session获取用户ID*/
		try {
			se = new SessionEntity(request);
			bEntity.setUser_basics_id(se.getUser_basics_id());
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			rs.setMessage("获取cookie信息失败！");
			return rs;
		}
		List<BankEntity> list = bankService.findAllBank(bEntity);
		//System.out.println("list的值："+list.size());
		try {
			String bank_card = String.valueOf( request.getParameter("bank_card"));
			/*遍历该用户下的所有银行卡号，是否与新增的银行卡号重复，如果重复则不新增，反之可新增*/
			for(BankEntity bankEntityList : list){
				if(bankEntityList.getBank_card().equals(bank_card)){
					rs.setIsSuccess(false);
					rs.setMessage("银行卡卡号已经存在，请更换银行卡添加！");
					return rs;
				}
			}
			bEntity.setBank_card(bank_card);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String cardholder_name = String.valueOf(request.getParameter("cardholder_name"));
			bEntity.setCardholder_name(cardholder_name);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String affiliated_bank = String.valueOf( request.getParameter("affiliated_bank"));
			bEntity.setAffiliated_bank(affiliated_bank);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String tel = String.valueOf(request.getParameter("tel"));
			bEntity.setTel(tel);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Integer card_type = Integer.valueOf(String.valueOf(request.getParameter("card_type")));
			bEntity.setCard_type(card_type);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			String depositBank_info = String.valueOf(request.getParameter("depositBank_info"));
			bEntity.setDepositBank_info(depositBank_info);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		BankEntity addBankEntity=bankService.addBank(bEntity);
		 if(addBankEntity!=null){
			 rs.setData(addBankEntity);
			 rs.setIsSuccess(true);
			 rs.setMessage("添加银行卡信息成功");
		 }else{
			 rs.setMessage("添加银行卡信息失败");
			 rs.setIsSuccess(false);
		 }
		
		return rs;
	}
	
	/**
	 * 
	 * @Title:             updateBank
	 * @Description:     TODO 修改银行卡信息
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:            vbl 
	 * @throws
	 */
	@RequestMapping("updateBank")
	public @ResponseBody ResponseData updateBank(HttpServletResponse response,HttpServletRequest request ){
		ResponseData rs = new ResponseData();
		BankEntity bEntity  = new BankEntity();
		try {
			Integer card_id = Integer.valueOf(String.valueOf(request.getParameter("card_id")));
			bEntity.setCard_id(card_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Integer user_basics_id = Integer.valueOf(String.valueOf(request.getParameter("user_basics_id")));
			bEntity.setUser_basics_id(user_basics_id);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			String bank_card = String.valueOf(request.getParameter("bank_card"));
			bEntity.setBank_card(bank_card);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			String affiliated_bank = String.valueOf(request.getParameter("affiliated_bank"));
			bEntity.setAffiliated_bank(affiliated_bank);
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String tel = String.valueOf(request.getParameter("tel"));
			bEntity.setTel(tel);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		try {
			Integer card_type = Integer.valueOf(String.valueOf(request.getParameter("card_type")));
			bEntity.setCard_type(card_type);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		int updateBank=bankService.updateBank(bEntity);
		 if(updateBank>0){
			 rs.setData(updateBank);
			 rs.setMessage("修改成功");
			 rs.setIsSuccess(true);
		 }else{
			 rs.setMessage("修改失败");
			 rs.setIsSuccess(false);
		 }
		
		return rs;
	}
}