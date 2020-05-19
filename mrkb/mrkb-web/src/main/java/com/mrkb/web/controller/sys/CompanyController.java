/**
 * FileName:         CompanyController.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-3     上午10:18:28
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-3     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.web.controller.sys;



import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mrkb.dao.dao.UserInformationMapper;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrkb.common.util.ResponseData;
import com.mrkb.common.utils.JsonUtils;
import com.mrkb.common.utils.publicUtil;
import com.mrkb.dao.modle.company.CoFounderMonSale;
import com.mrkb.dao.modle.company.CompanyBasicsEntity;
import com.mrkb.dao.modle.company.CompanyShow;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.service.CoFounderService;
import com.mrkb.service.CompanyBasicsService;
import com.mrkb.service.CompanyService;
import com.mrkb.service.UserService;




/**
 *@param
 *@return
 * @author moerka-1
 *
 */
@Controller("admin_company")
@RequestMapping("/admin_company")
public class CompanyController {
	@Autowired
	private UserService userService;
	@Autowired
	CompanyService companyService;
	@Autowired
	CompanyBasicsService companyBasicsService;
	@Autowired
	CoFounderService coFounderService;
	@Autowired
	UserInformationMapper userInformationMapper;
	
	
	
	@RequestMapping("coFounder")
	public String coFounder(HttpServletRequest request,HttpServletResponse response ){	
		return "sys/company/coFounder";
	}
	
	@RequestMapping("companyStaff")
	public String companyStaff(HttpServletRequest request,HttpServletResponse response ){	
		return "sys/company/companyStaff";
	}
	@RequestMapping("CoFounderSale")
	public String CoFounderSale(HttpServletRequest request,HttpServletResponse response ){	
		return "sys/company/CoFounderSale";
	}
	/**
	 * 
	 * @Title:             findUserInformation  修改公司
	 * @Description:     TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@RequestMapping("adminUpdateCompany")
//	@ResponseBody
//	public ResponseData adminUpdateCompany(HttpServletResponse response,
//			HttpServletRequest request){
//		ResponseData rs = new ResponseData();
//		String jsonStr=JsonUtils.getJsonStr(request);//获取前端提交的json数据 并转换为json字符串
//		JSONObject json=JSONObject.fromString(jsonStr);//将字符串转换为JSONObject对象
//		int company_id=Integer.valueOf(String.valueOf(json.get("company_id")));
//		CompanyBasicsEntity cbe=new CompanyBasicsEntity();
//		cbe.setCompany_id(company_id);
//		cbe=companyService.findone(cbe);
//		rs.setData(cbe);
//		rs.setMessage("返回成功");
//		rs.setIsSuccess(true);
//		return rs;
//		
//	}
	
	/**
	 * 
	 * @Title:             toAddCompany
	 * @Description:     TODO  添加分公司
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         String   
	 * @throws
	 */
//	@RequestMapping("addCompanySubsidiary")
//	@ResponseBody
//	public ResponseData addCompanySubsidiary(HttpServletResponse response,HttpServletRequest request,@RequestBody Map<String, Object> jsonData) {//返回添加公司页面
//		ResponseData rs = new ResponseData();
//		String company_telephone="无联系方式";//公司联系电话
//		Integer company_type=2;//公司类型 2为分公司
//		Integer if_founder=1;
//		CompanyBasicsEntity companyBasicsEntity=new CompanyBasicsEntity();
//		try {
//			company_telephone=String.valueOf(jsonData.get("company_telephone"));//获取前端提交的公司联系电话
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		Integer user_basics_id=Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));//获取前端提交的公司老总用户id 
//		String company_province=String.valueOf(jsonData.get("company_province"));//省份
//		String urban_district=String.valueOf(jsonData.get("urban_district"));//地区，市
//		String area=String.valueOf(jsonData.get("area"));//县
//		String company_name=String.valueOf(jsonData.get("company_name"));//公司名称
//		String company_account=String.valueOf(jsonData.get("company_account"));//公司账户
//		String company_address=String.valueOf(jsonData.get("company_address"));//公司地址 
//		Integer super_company_id=Integer.valueOf(String.valueOf(jsonData.get("super_company_id")));//上级公司编号 
//		Integer company_lv=Integer.valueOf(String.valueOf(jsonData.get("company_lv")));//公司等级
//		String low_company_id=String.valueOf(jsonData.get("low_company_id"));//下级公司
//		Long add_date=System.currentTimeMillis();
//		try {
//			Integer user_basics_id_referee=Integer.valueOf(String.valueOf(jsonData.get("user_basics_id_referee")));//公司推荐人ID
//			companyBasicsEntity.setUser_basics_id_referee(user_basics_id_referee);
//		} catch (Exception e) {
//			System.out.println("该体验中心无推荐人!");
//		}
//		if_founder=Integer.valueOf(String.valueOf(jsonData.get("if_founder")));
//		companyBasicsEntity.setIf_founder(if_founder);//公司老总是否拿提成
//		companyBasicsEntity.setCompany_telephone(company_telephone);
//		companyBasicsEntity.setUser_basics_id(user_basics_id);
//		companyBasicsEntity.setCompany_type(company_type);
//		companyBasicsEntity.setCompany_province(company_province);
//		companyBasicsEntity.setUrban_district(urban_district);
//		companyBasicsEntity.setArea(area);
//		companyBasicsEntity.setCompany_name(company_name);
//		companyBasicsEntity.setCompany_account(company_account);
//		companyBasicsEntity.setCompany_address(company_address);
//		companyBasicsEntity.setSuper_company_id(super_company_id);
//		companyBasicsEntity.setLow_company_id(low_company_id);
//		companyBasicsEntity.setAdd_date(add_date);
//		companyBasicsEntity.setStatus_state(1);
//		companyBasicsEntity.setCompany_money(0.00);
//		companyBasicsEntity.setIf_co(1);
//		companyBasicsEntity.setCompany_lv(company_lv);
//		companyBasicsEntity.setApply_date(add_date);
//		
//		int s=companyService.addCompany(companyBasicsEntity);//添加分公司信息
//		if(s>0){
//			rs.setMessage("添加成功!");
//			rs.setData(companyBasicsEntity);
//			rs.setIsSuccess(true);
//		}else{
//			rs.setMessage("添加失败!");
//			rs.setIsSuccess(false);
//		}
//		
//		return rs;
//		
//	}
	/**
	 * 
	 * @Title:             findUserInformation
	 * @Description:     TODO  添加公司页面->以用户id查询用户补充信息
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@RequestMapping("findUserInformation")
//	@ResponseBody
//	public ResponseData findUserInformation(HttpServletResponse response,
//			HttpServletRequest request){//以用户id查询用户补充信息
//		String jsonStr=JsonUtils.getJsonStr(request);//获取前端提交的json数据 并转换为json字符串
//		JSONObject json=JSONObject.fromString(jsonStr);//将字符串转换为JSONObject对象
//		//获取用户id
//		String superior_user_basics_id=String.valueOf(json.get("boss_user_basics_id"));//获取键为superior_user_basics_id的值
//		UserInformationEntity userInformationEntity =userService.findUserInformation(Integer.valueOf(superior_user_basics_id));
//		ResponseData rs = new ResponseData();
//		rs.setMessage("返回成功");
//		rs.setData(userInformationEntity);
//		rs.setIsSuccess(true);
//		return rs;
//		
//	}
	/**
	 * 
	 * @Title:             adminAddCoFounder
	 * @Description:     TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return    添加品牌大使
	 * @return:         ResponseData   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("adminAddCoFounder")
	public ResponseData adminAddCoFounder(HttpServletResponse response,
			HttpServletRequest request,@RequestBody UserInformationEntity ue){//以用户id查询用户补充信息
		ResponseData rs = new ResponseData();
		HashMap<String,Object> map=new HashMap<String,Object>();
		
		
		//获取用户id
		int user_grade_id=Integer.valueOf(ue.getUser_grade_id());
		Integer user_basics_id=Integer.valueOf(ue.getUser_basics_id());//品牌大使用户编号
		String user_account_num=ue.getUser_account_num();//账号
		String user_password=null;
		try {
			user_password=ue.getUser_password();//密码
			
		} catch (Exception e) {
			user_password="letang123456";
		}
		int update=0;
		Integer company_id=1;//公司编号
		//Integer user_basics_id_sup=Integer.valueOf(String.valueOf(json.get("user_basics_id_sup")));//公司老总ID
		map.put("user_password", user_password);
		map.put("user_basics_id", user_basics_id);
		map.put("company_id", company_id);
		map.put("user_account_num", user_account_num);
		map.put("user_grade_id", user_grade_id);
        map.put("consult_picture",ue.getConsult_picture());
        map.put("consult_view",ue.getConsult_view());
		//map.put("user_basics_id_sup", user_basics_id_sup);
		update=companyService.adminAddCoFounder(map);
		
		if(update==-2){
			rs.setMessage("该分公司不允许添加品牌大使!");
			rs.setIsSuccess(false);
		}else{
			rs.setMessage("添加成功!");
			rs.setIsSuccess(true);
			rs.setData(update);
		}
		return rs;
		
	}
	
	/**
	 * 
	 * @Title:             adminUpdateCoFounder
	 * @Description:     TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return    修改品牌大使
	 * @return:         ResponseData   
	 * @throws
	 */
	@ResponseBody
	@RequestMapping("adminUpdateCoFounder")
	public ResponseData adminUpdateCoFounder(HttpServletResponse response,
			HttpServletRequest request,@RequestBody UserInformationEntity ue){//以用户id查询用户补充信息
		ResponseData rs = new ResponseData();
		HashMap<String,Object> map=new HashMap<String,Object>();
		
		
		//获取用户id
		int old_user_basics_id=Integer.valueOf(ue.getOld_user_basics_id());
		int user_grade_id=Integer.valueOf(ue.getUser_grade_id());
		Integer user_basics_id=Integer.valueOf(ue.getUser_basics_id());//品牌大使用户编号
		String user_account_num=ue.getUser_account_num();//账号
		String user_password=null;
		try {
			user_password=ue.getUser_password();//密码
			
		} catch (Exception e) {
			user_password="letang123456";
		}
		int update=0;
		Integer company_id=1;//公司编号
		//Integer user_basics_id_sup=Integer.valueOf(String.valueOf(json.get("user_basics_id_sup")));//公司老总ID
		map.put("user_password", user_password);
		map.put("old_user_basics_id", old_user_basics_id);
		map.put("user_basics_id", user_basics_id);
		map.put("company_id", company_id);
		map.put("user_account_num", user_account_num);
		map.put("user_grade_id", user_grade_id);
        map.put("consult_picture",ue.getConsult_picture());
        map.put("consult_view",ue.getConsult_view());
		//map.put("user_basics_id_sup", user_basics_id_sup);
		UserInformationEntity ue1 = userInformationMapper.selectUserInformationEntityToUserId(user_basics_id);
		UserInformationEntity ue2 = userInformationMapper.selectUserInformationEntityToUserId(old_user_basics_id);
		if(ue1==null||ue2==null){
			rs.setMessage("用户不存在!");
			rs.setIsSuccess(false);
			rs.setData(update);
			return rs;
		}
		if(ue2.getCo_founder()!=4){
			rs.setMessage("老员工不存在!");
			rs.setIsSuccess(false);
			rs.setData(update);
			return rs;
		}
		update=companyService.adminAddCoFounder(map);
		companyService.adminUpdateCoFounder(map);
		rs.setMessage("更换成功!");
		rs.setIsSuccess(true);
		rs.setData(update);
		return rs;
		
	}
	/**
	 * 
	 * @Title:             findAllUserBasics
	 * @Description:     TODO 查询会员基本信息
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   添加公司页面->查询会员基本信息
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@RequestMapping("findUserBasics")
//	@ResponseBody
//	public ResponseData findUserBasics(HttpServletResponse response,HttpServletRequest request) {//查询会员基本信息
//		ResponseData rs = new ResponseData();
//		String jsonStr=JsonUtils.getJsonStr(request);//获取前端提交的json数据 并转换为json字符串
//		JSONObject json=JSONObject.fromString(jsonStr);//将字符串转换为JSONObject对象
//		//获取用户id
//		String superior_user_basics_id=String.valueOf(json.get("boss_user_basics_id"));//获取键为superior_user_basics_id的值
//		if(!publicUtil.isNum(superior_user_basics_id)){
//			rs.setMessage("boss_user_basics_id获取错误");
//			return rs;
//		}
//		BasicsUser basicsUser=userService.finduserBasics(Integer.valueOf(superior_user_basics_id));
//		rs.setData(basicsUser);
//		rs.setIsSuccess(true);
//		rs.setMessage("返回成功");
//		return rs;
//	}
	/**
	 * 
	 * @Title:             findCompanyShowAll
	 * @Description:     TODO 查询全部公司信息
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@RequestMapping("findCompanyShowAll")
//	@ResponseBody
//	public ResponseData findCompanyShowAll(HttpServletResponse response,
//			HttpServletRequest request){
//		ResponseData rs = new ResponseData();
//		//String jsonStr=JsonUtils.getJsonStr(request);//获取前端提交的json数据 并转换为json字符串
//		//JSONObject json=JSONObject.fromString(jsonStr);//将字符串转换为JSONObject对象
//		int company_type=0;//公司类型0为全部公司
//		List<CompanyShow>companyShowList=companyService.findCompanyShow(company_type);//查询显示公司信息所需数据
//		rs.setMessage("返回成功");
//		rs.setIsSuccess(true);
//		rs.setData(companyShowList);
//		return rs;
//		
//	}
	/**
	 * 
	 * @Title:             findCompanyShowAll
	 * @Description:     TODO 查询全部公司信息
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@RequestMapping("findComOne")
//	@ResponseBody
//	public ResponseData findComOne(HttpServletResponse response,
//			HttpServletRequest request){
//		ResponseData rs = new ResponseData();
//		String jsonStr=JsonUtils.getJsonStr(request);//获取前端提交的json数据 并转换为json字符串
//		JSONObject json=JSONObject.fromString(jsonStr);//将字符串转换为JSONObject对象
//		CompanyBasicsEntity cbe=new CompanyBasicsEntity();
//		try {
//			int company_id=Integer.valueOf(String.valueOf(json.get("company_id")));//公司编号
//			cbe.setCompany_id(company_id);
//		} catch (Exception e) {
//			
//		}
//		try {
//			int company_lv=Integer.valueOf(String.valueOf(json.get("company_lv")));//公司类型
//			cbe.setCompany_lv(company_lv);
//		} catch (Exception e) {
//			
//		}
//		CompanyBasicsEntity cbey=companyService.findone(cbe);
//		rs.setMessage("返回成功");
//		rs.setData(cbey);
//		rs.setIsSuccess(true);
//		return rs;
//		
//	}
	/**
	 * 
	 * @Title:             findCompany
	 * @Description:     TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@PrivilegeInfo(privilege_operate_name="查询某个等级公司信息",privilege_code_num=1)
//	@RequestMapping("findCompany")
//	public @ResponseBody VisitConsequenceParent findCompany(HttpServletResponse response,
//			HttpServletRequest request,@RequestBody Map<String,Object>jsonData){
//		ResponseData rs = new ResponseData();
//		CompanyBasicsEntity cbe=new CompanyBasicsEntity();
//		Integer company_lv = Integer.valueOf(String.valueOf(jsonData.get("company_lv")));
//		cbe.setCompany_lv(company_lv);
//		if(company_lv>1){
//			String company_province = String.valueOf(jsonData.get("company_province"));
//			cbe.setCompany_province(company_province);
//		}
//		
//		List<CompanyBasicsEntity> cbey=companyService.findLv(cbe);//查询显示公司信息所需数据
//		vc.setMessage("返回成功");
//		vc.setState(0);
//		vc.setObject(cbey);
//		return vc;
//		
//	}
	
	
	
	/**
	 * 
	 * @Title:             findAllGrade
	 * @Description:     TODO 查询所有等级的信息
	 * @param:             @return   
	 * @return:         VisitConsequenceParent 封装ajax请求的返回  object属性为后台的返回的数据
	 * @throws
	 */
//	@PrivilegeInfo(privilege_operate_name="添加公司奖励=>查询所有等级信息",privilege_code_num=1)
//	@RequestMapping("findAllGrade")
//	public VisitConsequenceParent findAllGrade(){//查询所有等级的信息
//		return null;
//		
//	}

	/**
	 * 
	 * @Title:             addCompany
	 * @Description:     TODO 添加一条会员信息 用户昵称与用户密码为必填项
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         CompanyBasicsEntity 公司实体
	 * @throws
	 */
//	@PrivilegeInfo(privilege_operate_name="添加公司",privilege_code_num=1)
//	@RequestMapping("addCompany")
//	public String addCompany(HttpServletResponse response,HttpServletRequest request) {
//		Integer user_basics_id=Integer.valueOf(request.getParameter("user_basics_id"));//领衔人ID
//		String company_telephone=request.getParameter("company_telephone");//分公司联系电话
//		String company_address=request.getParameter("company_address");//分公司地址
//		String company_account=request.getParameter("company_account");//分公司账户号
//		String company_name=request.getParameter("company_name");//分公司账户号
//		CompanyBasicsEntity cbe=new CompanyBasicsEntity();
//		Long time = System.currentTimeMillis();
//		Integer company_type=2;//公司类型 1：总公司，2：分公司
//		Double company_money=0.00;//公司起始金额
//		Integer status_state=1;//待审核
//		cbe.setUser_basics_id(user_basics_id);
//		cbe.setCompany_telephone(company_telephone);
//		cbe.setCompany_type(company_type);
//		cbe.setCompany_address(company_address);
//		cbe.setCompany_account(company_account);
//		cbe.setCompany_money(company_money);
//		cbe.setStatus_state(status_state);
//		cbe.setAdd_date(time);
//		cbe.setCompany_name(company_name);
//		int add=companyBasicsService.addCompany(cbe);
//		if(add>0){
//			request.setAttribute("status", 0);
//			return "admin/company/adminAddCompany";
//		}else{
//			request.setAttribute("status", 0);
//			return "admin/company/adminAddCompany";
//		}
//		
//	}

	/**
	 * 返回公司审核页面
	 * @param response
	 * @param request  
	 * @return  fund
	 */
//	@PrivilegeInfo(privilege_operate_name = "返回公司审核页面", privilege_code_num = 1)
//	@RequestMapping("tofindCompanyBasics")
//	public String tofindFompanyBasics(HttpServletResponse response,HttpServletRequest request) {
//		HtmlEntity htmlEntity=new HtmlEntity();
//		htmlEntity.setTitle1("查询");
//		htmlEntity.setTitle2("公司");
//		htmlEntity.setTitle3("申请状态");
//		request.setAttribute("htmlEntity", htmlEntity);
//		return "admin/company/findCompanyBasics";
//	}
	/**
	 * 
	 * @Title:             findCompanyShowAll
	 * @Description:     TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@PrivilegeInfo(privilege_operate_name="查询全部公司信息",privilege_code_num=1)
//	@RequestMapping("findAllCompanyBasics")
//	@ResponseBody
//	public VisitConsequenceParent findAllCompanyBasics(HttpServletResponse response,
//			HttpServletRequest request,
//			@RequestBody Map<String, Object> jsonData){
//		VisitConsequenceParent vc=new VisitConsequenceParentImpl();
//		HashMap<String, Object> map = new HashMap<String, Object>();
//	     try {
//	    	 Integer state = Integer.valueOf(String.valueOf(jsonData.get("state")));
//			 map.put("status_state", state);
//		} catch (NumberFormatException e) {
//			}
//		List<CompanyBasicsEntity> lsCompany = companyBasicsService.findCompanyBasics(map);//查询显示公司信息所需数据
//		System.out.println("查询结果："+lsCompany);
//		vc.setMessage("返回成功");
//		vc.setState(0);
//		vc.setObject(lsCompany);
//		return vc;
//		
//	}
	/**
	 * 
	 * @Title:             updateCompanyBasics
	 * @Description:     TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@PrivilegeInfo(privilege_operate_name="修改公司类型、状态",privilege_code_num=1)
//	@RequestMapping("updateCompanyBasics")
//	@ResponseBody
//	public VisitConsequenceParent updateCompanyBasics(HttpServletResponse response,
//			HttpServletRequest request,
//			@RequestBody Map<String, Object> jsonData){
//		VisitConsequenceParent vc=new VisitConsequenceParentImpl();
//		CompanyBasicsEntity company = new CompanyBasicsEntity();
//	     try {//公司ID
//			Integer company_id = Integer.valueOf(String.valueOf(jsonData.get("company_id")));
//			company.setCompany_id(company_id);
//		} catch (NumberFormatException e) {
//		}
//	    try {//公司ID
//			Integer user_basics_id = Integer.valueOf(String.valueOf(jsonData.get("user_basics_id")));
//			company.setUser_basics_id(user_basics_id);
//		} catch (NumberFormatException e) {
//		}
//	     Long examine_date=System.currentTimeMillis();
//	     company.setExamine_date(examine_date);
//	     company.setStatus_state(4);
//	     company = companyBasicsService.upComBasicsAnduinformation(company);
//		vc.setMessage("返回成功");
//		vc.setState(0);
//		vc.setObject(company);
//		return vc;
//		
//	}
	/**
	 * 
	 * @Title:             upComBasicsAnduinformation
	 * @Description:     TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@PrivilegeInfo(privilege_operate_name="通过公司申请",privilege_code_num=1)
//	@RequestMapping("updateCompanyBasicsAgree")
//	@ResponseBody
//	public VisitConsequenceParent upComBasicsAnduinformation(HttpServletResponse response,
//			HttpServletRequest request,
//			@RequestBody Map<String, Object> jsonData){
//		VisitConsequenceParent vc=new VisitConsequenceParentImpl();
//		CompanyBasicsEntity companyBasics = new CompanyBasicsEntity();
//	     try {
//			Integer company_id = Integer.valueOf(String.valueOf(jsonData.get("company_id")));
//			companyBasics.setCompany_id(company_id);
//		} catch (NumberFormatException e) {
//		}
//	    Long apply_date = System.currentTimeMillis();
//	    companyBasics.setApply_date(apply_date);
//	    companyBasics.setStatus_state(0);
//	    int company = companyBasicsService.updateCompanyBasicsAgree(companyBasics);
//		vc.setMessage("返回成功");
//		vc.setState(0);
//		vc.setObject(company);
//		return vc;
//		
//	}
	/**
	 * 
	 * @Title:             updateCompanyBasicsRefuse
	 * @Description:     TODO
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
//	@PrivilegeInfo(privilege_operate_name="拒绝公司申请",privilege_code_num=1)
//	@RequestMapping("updateCompanyBasicsRefuse")
//	@ResponseBody
//	public VisitConsequenceParent updateCompanyBasicsRefuse(HttpServletResponse response,
//			HttpServletRequest request,
//			@RequestBody Map<String, Object> jsonData){
//		VisitConsequenceParent vc=new VisitConsequenceParentImpl();
//		CompanyBasicsEntity companyBasics = new CompanyBasicsEntity();
//	     try {
//			Integer company_id = Integer.valueOf(String.valueOf(jsonData.get("company_id")));
//			companyBasics.setCompany_id(company_id);
//		} catch (NumberFormatException e) {
//		}
//	    Long apply_date = System.currentTimeMillis();
//	    companyBasics.setApply_date(apply_date);
//	    companyBasics.setStatus_state(2);
//	    int company = companyBasicsService.updateCompanyBasicsAgree(companyBasics);
//		vc.setMessage("返回成功");
//		vc.setState(0);
//		vc.setObject(company);
//		return vc;
//		
//	}
	
	/**
	 * 
	 * @Title:             findCoFounder
	 * @Description:       查询品牌大使销售
	 * @param:             @param response
	 * @param:             @param request
	 * @param:             @return   
	 * @return:         VisitConsequenceParent   
	 * @throws
	 */
	@RequestMapping("findCoFounder")
	@ResponseBody
	public ResponseData findCoFounder(HttpServletResponse response,@RequestParam("pageSize") Integer pageSize,@RequestParam("pageIndex") Integer pageIndex
			,HttpServletRequest request){
		ResponseData rd=new ResponseData();
		PageHelper.startPage(pageIndex, pageSize);
		HashMap<String,Object> map=new HashMap<String,Object>();
		try {
			int month_date=Integer.valueOf(request.getParameter("month_date"));
			map.put("month_date", month_date);
		} catch (Exception e) {
			// TODO: handle exception
		}
		List<CoFounderMonSale> lcs=coFounderService.findCompanyCo(map);
		PageInfo<CoFounderMonSale> PageInfo = new PageInfo<>(lcs);
		rd.setData(PageInfo);
		rd.setMessage("查询成功!");
		rd.setIsSuccess(true);
		return rd;
		
	}
}
