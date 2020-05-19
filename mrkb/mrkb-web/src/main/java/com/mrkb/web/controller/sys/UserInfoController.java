package com.mrkb.web.controller.sys;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mrkb.dao.dao.BasicUserMapper;
import com.mrkb.dao.modle.user.*;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import com.mrkb.dao.dao.UserDutyMapper;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.dao.UserRecommendMapper;
import com.mrkb.dao.modle.store.UserDuty;
import com.mrkb.service.UserService;
import com.mrkb.shiro.model.User;

/***
 * 会员信息管理controller
 *
 * @author ly
 *
 */
@Controller
@RequestMapping("/admin_userInfo")
public class UserInfoController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserInformationMapper userInformationMapper;
	@Autowired
	private UserRecommendMapper userRecommendMapper;
	@Autowired
	private UserDutyMapper userDutyMapper;
	@Autowired
	private BasicUserMapper basicUserMapper;
	/**
	 * 会员管理跳转页面
	 *
	 * @return 杩斿洖/sys/storeManage.html
	 */
	@RequestMapping("/userInfoCo")
	public String userInfoCo() {
		return "sys/user/userInfoCo";
	}
	/**
	 * 会员管理跳转页面
	 *
	 * @return 杩斿洖/sys/storeManage.html
	 */
	@RequestMapping("/userInfoManage")
	public String toUserInfoList() {
		return "sys/user/userInfoManage";
	}

	/**
	 * 跳转页面 导出所有所属员工 当班课程数据
	 *
	 * @return 杩斿洖/sys/user/exportAllUserDutyManage.html
	 */
	@RequestMapping("/toExportAllUserDutyManage")
	public String toExportAllUserDutyManage() {
		return "sys/user/exportAllUserDutyManage";
	}

	/**
	 * 跳转页面 导出单个所属员工 当班课程数据
	 *
	 * @return 杩斿洖/sys/user/exportAllUserDutyManage.html
	 */
	@RequestMapping("/toExportOneUserDutyManage")
	public String toExportOneUserDutyManage() {
		return "sys/user/exportOneUserDutyManage";
	}

	/**
	 * 管理列表信息展示
	 *
	 * @param pageNum
	 * @param pageSize
	 * @param name
	 * @return
	 */

	@ResponseBody
	@RequestMapping("/userInfoListCo/{pageNum}/{pageSize}")
	public ResponseData userInofListoCo(@PathVariable("pageNum") Integer pageNum,
										@PathVariable("pageSize") Integer pageSize, HttpServletRequest req) {
		ResponseData R = new ResponseData();
		//获取登录用户的信息
		User user = new User();
		Subject subject = SecurityUtils.getSubject();
		user = (User) subject.getPrincipal();// 获取用户信息
		String userName = req.getParameter("name");//
		PageHelper.startPage(pageNum, pageSize);
		List<TeamInformation> userInfoList = userService.findTeamInformationByPage(userName, null,null, user.getUser_basics_id());
		PageInfo<TeamInformation> PageInfo = new PageInfo<>(userInfoList);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(PageInfo);
		return R;
	}
	@ResponseBody
	@RequestMapping("/userInfoList/{pageNum}/{pageSize}")
	public ResponseData userInofList(@PathVariable("pageNum") Integer pageNum,
									 @PathVariable("pageSize") Integer pageSize, HttpServletRequest req) {
		ResponseData R = new ResponseData();
		String userName = req.getParameter("name");//
		PageHelper.startPage(pageNum, pageSize);
		List<TeamInformation> userInfoList = userService.findTeamInformationByPage(userName, null, null,null);
		PageInfo<TeamInformation> PageInfo = new PageInfo<>(userInfoList);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(PageInfo);
		return R;
	}

	/**
	 * 查询单个会员详情信息
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/getByUserInfoId/{id}")
	public ResponseData findById(@PathVariable("id") Integer id) {
		ResponseData R = new ResponseData();
		TeamInformation teamInformation = userService.findTeamInformationById(id);
		if (teamInformation != null) {
			R.setData(teamInformation);
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
	 * @Title: findAllUserBasicsAndGrade @Description: TODO @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         VisitConsequenceParent @throws
	 */
	@RequestMapping("/findUserBasicsAndGradeId/{id}")
	@ResponseBody
	public ResponseData findUserBasicsAndGradeId(@PathVariable("id") Integer id) {
		ResponseData R = new ResponseData();
		BasicsAndGradeEntity beEntityId = userService.selectUserBasicsAndGradeId(id);
		if (beEntityId != null) {
			R.setData(beEntityId);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 会员等级跳转页面
	 *
	 * @return sys/user/userGradeManage.html
	 */
	@RequestMapping("/userGradeManage")
	public String toUserGradeList() {
		return "sys/user/userGradeManage";
	}

	/**
	 *
	 * @Title: findAllUserGrade @Description: TODO 查询会员等级 @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         ResponseData @throws
	 */
	@ResponseBody
	@RequestMapping("/findAllUserGrade/{pageNum}/{pageSize}")
	public ResponseData findAllUserGrade(HttpServletRequest req, @PathVariable("pageNum") Integer pageNum,
										 @PathVariable("pageSize") Integer pageSize) {
		ResponseData R = new ResponseData();
		// List<UserGrade>userGradeList=userService.findAllGrade();//查询会员等级
		String userName = req.getParameter("name");//
		PageHelper.startPage(pageNum, pageSize);
		List<UserGrade> userGradeList = userService.findAllGrade();// 查询会员等级
		PageInfo<UserGrade> PageInfo = new PageInfo<>(userGradeList);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(PageInfo);
		return R;

	}

	/**
	 *
	 * @Title: getByuserGradeId @Description: 会员等级详情查询 @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         ResponseData @throws
	 */
	@RequestMapping("/getByuserGradeId/{id}")
	@ResponseBody
	public ResponseData findUserGradeId(@PathVariable("id") Integer id) {
		ResponseData R = new ResponseData();
		UserGrade userGradeEntity = userService.findUserGrade(id);
		if (userGradeEntity != null) {
			R.setData(userGradeEntity);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 修改会员等级信息
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editUserGrade")
	public ResponseData editUserGrade(@RequestBody UserGrade userGrade) {
		ResponseData R = new ResponseData();
		Integer num = userService.updateUserGrade(userGrade);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 *
	 * @Title: protocolAdd @Description: TODO 新增协议 @param: @param
	 *         ProtocolEntity @param: @return @return: r @throws
	 */
	@ResponseBody
	@RequestMapping("/userGradeAdd")
	public ResponseData protocolAdd(@RequestBody UserGrade userGrade) {
		ResponseData r = new ResponseData();
		int addUserGradeEntity = userService.userGradeAdd(userGrade);
		if (addUserGradeEntity > 0) {
			r.setErrorCode(ResponseCode.SUCC_DO.getCode());
			r.setMessage(ResponseCode.SUCC_DO.getMsg());
			return r;
		}
		r.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		r.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return r;
	}

	/**
	 *
	 * @Title: findUserGrade @Description: TODO 查询所有品牌大使 @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         list<UserInformationEntity> @throws
	 */
	@ResponseBody
	@RequestMapping("findUserInformation")
	public ResponseData findUserInformation(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		int co_founder = Integer.valueOf(request.getParameter("co_founder"));
		UserInformationEntity ui = new UserInformationEntity();
		ui.setCo_founder(co_founder);
		List<UserInformationEntity> listUie = userService.findCoFounds(ui);
		rs.setMessage("查询成功");
		rs.setIsSuccess(true);
		rs.setData(listUie);

		return rs;
	}

	/**
	 *
	 * @Title: findUserInformOne @Description: TODO 查询单个用户补充信息 @param: @param
	 *         response @param: @param request
	 *         包含json对象， @param: @return @return: UserInformationEntity @throws
	 */
	@ResponseBody
	@RequestMapping("findUserInformOne")
	public ResponseData findUserInformOne(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		String sss = request.getParameter("user_basics_id");
		int user_basics_id = Integer.valueOf(request.getParameter("user_basics_id"));
		UserInformationEntity uie = userService.findUserInformation(user_basics_id);
		System.out.println(user_basics_id);
		System.out.println("uie::::::::::::::::" + uie);
		rs.setData(uie);
		rs.setMessage("查询成功");
		rs.setIsSuccess(true);
		rs.setErrorCode(ResponseCode.SUCC_DO.getCode());
		return rs;
	}

	/**
	 * 跳转到我的顾问展示页面
	 *
	 * @param request
	 * @param response
	 * @return
	 */

	@RequestMapping("toUserConsultService")
	public String bigFoison(HttpServletRequest request, HttpServletResponse response) {
		return "sys/user/userConsultService";
	}

	/**
	 *
	 * @Title: findUserInformById @Description: TODO 查询乐唐员工通过user_basics_id ,
	 *         is_employee @param: @param response @param: @param request
	 *         包含json对象， @param: @return @return: UserInformationEntity @throws
	 */
	@ResponseBody
	@RequestMapping("findUserInformById")
	public ResponseData findUserInformById(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		String userId = request.getParameter("user_basics_id");
		String isEmployee = request.getParameter("is_employee");
		UserInformationEntity userInformationEntity = new UserInformationEntity();
		userInformationEntity.setUser_basics_id(Integer.valueOf(userId));
		userInformationEntity.setIs_employee(Integer.valueOf(isEmployee));
		UserInformationEntity uie = userService.selectUserById(userInformationEntity);
		// System.out.println(user_basics_id);
		System.out.println("uie::::::::::::::::" + uie);
		rs.setData(uie);
		rs.setMessage("查询成功");
		rs.setIsSuccess(true);
		rs.setErrorCode(ResponseCode.SUCC_DO.getCode());
		return rs;
	}

	/**
	 *
	 * @Title: adminAddUserConsultService
	 * @Description: TODO @param: @param response @param: @param
	 *               request @param: @return 添加我的顾问 @return:
	 *               VisitConsequenceParent @throws
	 */
	@RequestMapping("adminAddUserConsultService")
	@ResponseBody
	public ResponseData adminAddUserConsultService(@RequestBody UserConsultServiceEntity ue) {
		ResponseData r = new ResponseData();
		Integer user_basics_id = ue.getUser_basics_id();// 品牌大使用户编号
		Integer advisor_user_basics_id = ue.getAdvisor_user_basics_id();// 顾问id
		Integer seniorManager_user_basics_id = ue.getSeniorManager_user_basics_id();// 经理id
		//
		/*UserInformationEntity userInformationEntity = new UserInformationEntity();
		userInformationEntity.setAdvisor_user_basics_id(advisor_user_basics_id);
		userInformationEntity.setUser_basics_id(user_basics_id);
		userInformationEntity.setSeniorManager_user_basics_id(seniorManager_user_basics_id);
		int update = userService.updateUserInformation(userInformationEntity);*/
		/* 根据user_basics_id查询user_consult_service信息 */
		UserConsultServiceEntity userConsultServiceEntity = new UserConsultServiceEntity();
		userConsultServiceEntity.setUser_basics_id(user_basics_id);
        userConsultServiceEntity.setSenior_manager_name(ue.getSenior_manager_name());
        userConsultServiceEntity.setSenior_manager_phone(ue.getSenior_manager_phone());
		UserConsultServiceEntity entity = userService.findUserConsultserviceById(userConsultServiceEntity);
		if (entity == null) { // 则为新增
			int addNum = userService.addUserConsultService(ue);
			if (addNum > 0) {
				r.setErrorCode(ResponseCode.SUCC_DO.getCode());
				r.setMessage(ResponseCode.SUCC_DO.getMsg());
				return r;
			} else {
				r.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
				r.setMessage(ResponseCode.ERROR_FAIL.getMsg());
				return r;
			}
		} else { // 则为修改
			int updateNum = userService.updateUserConsultservice(ue);
			if (updateNum > 0) {
				r.setErrorCode(ResponseCode.SUCC_DO.getCode());
				r.setMessage(ResponseCode.SUCC_DO.getMsg());
				return r;
			} else {
				r.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
				r.setMessage(ResponseCode.ERROR_FAIL.getMsg());
				return r;
			}
		}
	}

	/**
	 * 我的顾问列表信息展示
	 *
	 * @param pageNum
	 * @param pageSize
	 * @param
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/findAllUserConsultService/{pageNum}/{pageSize}")
	public ResponseData findAllUserConsultService(@PathVariable("pageNum") Integer pageNum,
												  @PathVariable("pageSize") Integer pageSize, HttpServletRequest req) {
		ResponseData R = new ResponseData();
		UserConsultServiceEntity entity = new UserConsultServiceEntity();
		PageHelper.startPage(pageNum, pageSize);
		List<UserConsultServiceEntity> userConsultServicelist = userService.findAllUserConsultService(entity);// 查询协议列表
		PageInfo<UserConsultServiceEntity> PageInfo = new PageInfo<>(userConsultServicelist);
		R.setErrorCode(ResponseCode.SUCC_DO.getCode());
		R.setMessage(ResponseCode.SUCC_DO.getMsg());
		R.setData(PageInfo);
		return R;
	}

	/**
	 *
	 * @Title: getByUserConsultServiceId @Description: TODO
	 *         查询单个顾问信息 @param: @param id @param: @return R @return: @throws
	 */

	@RequestMapping("/getByUserConsultServiceId/{id}")
	public @ResponseBody ResponseData getBygetByUserConsultServiceIdProtocolId(@PathVariable("id") Integer id) {
		UserConsultServiceEntity entity = new UserConsultServiceEntity();
		ResponseData R = new ResponseData();
		entity.setUser_basics_id(id);
		UserConsultServiceEntity eConsultServiceEntity = userService.findUserConsultserviceById(entity);
		if (eConsultServiceEntity != null) {
			R.setData(eConsultServiceEntity);
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setErrorCode(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 修改协议信息
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/editUserConsultService")
	public ResponseData editUserConsultService(@RequestBody UserConsultServiceEntity userConsultServiceEntity) {
		ResponseData R = new ResponseData();
		UserInformationEntity userEntity = new UserInformationEntity();
		userEntity.setUser_basics_id(userConsultServiceEntity.getUser_basics_id());// 用户id
		userEntity.setAdvisor_user_basics_id(userConsultServiceEntity.getAdvisor_user_basics_id());// 乐唐顾问id
		userEntity.setSeniorManager_user_basics_id(userConsultServiceEntity.getSeniorManager_user_basics_id());// 高级经理id
		userService.updateUserInformation(userEntity);// 更新用户信息表user_information
		Integer num = userService.updateUserConsultservice(userConsultServiceEntity);
		if (num > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 修改客户员工,分配供公司资源和个人资源
	 *
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/updateCoFounder")
	public ResponseData updateCoFounder(HttpServletResponse response, HttpServletRequest request) {
		System.out.println("开始修改!");
		ResponseData R = new ResponseData();

		UserInformationEntity userEntity = new UserInformationEntity();
		int user_basics_id = Integer.valueOf(request.getParameter("user_basics_id").toString());
		if(user_basics_id==1){
			R.setIsSuccess(false);
			R.setMessage("修改失败!");
			return R;
		}
		int co_user_basics_id = Integer.valueOf(request.getParameter("co_user_basics_id").toString());
		int user_resources = Integer.valueOf(request.getParameter("user_resources").toString());
		int recommend_superior = Integer.valueOf(request.getParameter("recommend_superior").toString());
		int user_grade_id = Integer.valueOf(request.getParameter("user_grade_id").toString());
		UserInformationEntity ue = userInformationMapper.selectUserInformationEntityToUserId(user_basics_id);
		BasicsUser bu=basicUserMapper.findUserBasics(user_basics_id);
		if(bu.getUser_grade_id()<3&&user_grade_id<=3&&user_grade_id!=1){
			bu.setUser_grade_id(user_grade_id);
			int s=basicUserMapper.updateUserBasics(bu);
		}
		int re_user_basics_id = userRecommendMapper.selectSuperUserId(user_basics_id);// 现在的推荐人
		if (ue.getCo_user_basics_id() != co_user_basics_id && !ue.getCo_user_basics_id().equals(co_user_basics_id)) {
			UserInformationEntity ue1 = userInformationMapper.selectUserInformationEntityToUserId(co_user_basics_id);
			if(ue1!=null&&ue1.getUser_basics_id()!=null&&ue1.getCo_founder()==4){
				ue.setCo_user_basics_id(co_user_basics_id);
			}else{
				R.setData(-1);
				R.setIsSuccess(false);
				R.setMessage("员工不存在!");
				return R;
			}

		}
		if (ue.getUser_resources() != user_resources && !ue.getUser_resources().equals(user_resources)) {
			ue.setUser_resources(user_resources);

		}

		if (re_user_basics_id != recommend_superior) {
			List<UserDuty> lud = userDutyMapper.noduty(user_basics_id);
			UserRecommend ur = new UserRecommend();
			ur.setRecommend_superior(recommend_superior);
			ur.setUser_basics_id(user_basics_id);
			UserInformationEntity ue1 = userInformationMapper.selectUserInformationEntityToUserId(recommend_superior);
			if (lud.size() > 0) {
				R.setData(-1);
				R.setIsSuccess(false);
				R.setMessage("用户有未当班的课程,不能修改推荐人!");
				return R;
			}
			if(ue1!=null&&ue1.getUser_basics_id()!=null) {
				userRecommendMapper.updateUserRecommend(ur);
			}else{
				R.setData(-1);
				R.setIsSuccess(false);
				R.setMessage("推荐人不存在!");
				return R;
			}
		}
		int update = userInformationMapper.updateUserInformation(ue);
		if (update == 1) {
			R.setData(update);
			R.setIsSuccess(true);
			R.setMessage("修改成功!");
		} else {
			R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
			R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		}

		return R;
	}

	/**
	 * 导出所有所属员工 当班课程数据
	 */

	@ResponseBody
	@RequestMapping("/excelFindAllDutyList")
	public ResponseData excelFindAllDutyList(HttpServletResponse response, HttpServletRequest request) {
		ResponseData R = new ResponseData();
		UserInformationEntity userEntity = new UserInformationEntity();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Integer num =
		// userService.updateUserConsultservice(userConsultServiceEntity);
		try {
			String begin_time = request.getParameter("begin_time");// 开始时间
			String end_time = request.getParameter("end_time");// 结束时间
			if (begin_time.equals(end_time) && !begin_time.equals("0") && !end_time.equals("0")) {// 开始日期和结束日期相同
				// 根据年月查询
				// 参数格式
				// ：2019-12
				// end_time= end_time.replace("-",",");
				String[] timeArray = end_time.split("-");
				if (timeArray[1].equals("12")) {
					int year = Integer.valueOf(timeArray[0]) + 1;
					int month = 01;
					end_time = String.valueOf(year) + "-0" + String.valueOf(month) + "-01 00:00:00";
					begin_time = begin_time + "-01 00:00:00";
				} else {
					int year = Integer.valueOf(timeArray[0]);
					int month = Integer.valueOf(timeArray[1]) + 1;
					if(month<10){//月份小与10 则默认补充0
						end_time = String.valueOf(year) + "-0" + String.valueOf(month) + "-01 00:00:00";
					}else{
						end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					}
					//end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					begin_time = begin_time + "-01 00:00:00";

				}
				userEntity.setBegin_time(sdf.parse(begin_time).getTime());
				userEntity.setEnd_time(sdf.parse(end_time).getTime());

			} else if (!begin_time.equals(end_time) && !begin_time.equals("0") && !end_time.equals("0")) {// 开始日期和结束日期不同
				String[] timeArray = end_time.split("-");
				if (timeArray[1].equals("12")) {
					int year = Integer.valueOf(timeArray[0]) + 1;
					int month = 01;
					end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					begin_time = begin_time + "-01 00:00:00";
				} else {
					int year = Integer.valueOf(timeArray[0]);
					int month = Integer.valueOf(timeArray[1]) + 1;
					if(month<10){//月份小与10 则默认补充0
						end_time = String.valueOf(year) + "-0" + String.valueOf(month) + "-01 00:00:00";
					}else{
						end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					}
					//end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					begin_time = begin_time + "-01 00:00:00";

				}
				userEntity.setBegin_time(sdf.parse(begin_time).getTime());// 开始日期格式转成时间戳
				userEntity.setEnd_time(sdf.parse(end_time).getTime());// 结束日期格式转成时间戳
				// 并注入
			} else {// 不选日期格式 默认
				userEntity.setBegin_time(0);
				userEntity.setEnd_time(0);
			}
			System.out.println("打印时间格式" + begin_time + "," + end_time);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String if_duty = request.getParameter("if_duty");// 是否当班类型
			if (if_duty.equals("-1")) {
				userEntity.setIf_duty(null);
			} else {
				userEntity.setIf_duty(Integer.valueOf(if_duty));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String source_type = request.getParameter("source_type");// 课程来源
			if (source_type.equals("0")) {
				userEntity.setSource_type(null);
			} else {
				userEntity.setSource_type(Integer.valueOf(source_type));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<UserInformationEntity> list = userInformationMapper.selectExportDuty(userEntity);// 更新用户信息表user_information
		if (list.size() > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setData(list);
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}

	/**
	 * 导出单个所属员工 当班课程数据
	 */

	@ResponseBody
	@RequestMapping("/excelFindByUserIdDuty")
	public ResponseData excelFindByUserIdDuty(HttpServletResponse response, HttpServletRequest request) {
		ResponseData R = new ResponseData();
		UserInformationEntity userEntity = new UserInformationEntity();
		User user = new User();
		Subject subject = SecurityUtils.getSubject();
		user = (User) subject.getPrincipal();// 获取用户信息
		userEntity.setUser_basics_id(user.getUser_basics_id());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		// Integer num =
		// userService.updateUserConsultservice(userConsultServiceEntity);
		try {
			String begin_time = request.getParameter("begin_time");// 开始时间
			String end_time = request.getParameter("end_time");// 结束时间
			if (begin_time.equals(end_time) && !begin_time.equals("0") && !end_time.equals("0")) {// 开始日期和结束日期相同
				String[] timeArray = end_time.split("-");
				if (timeArray[1].equals("12")) {
					int year = Integer.valueOf(timeArray[0]) + 1;
					int month = 01;
					end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					begin_time = begin_time + "-01 00:00:00";
				} else {
					int year = Integer.valueOf(timeArray[0]);
					int month = Integer.valueOf(timeArray[1]) + 1;
					if(month<10){//月份小与10 则默认补充0
						end_time = String.valueOf(year) + "-0" + String.valueOf(month) + "-01 00:00:00";
					}else{
						end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					}
					begin_time = begin_time + "-01 00:00:00";

				}
				userEntity.setBegin_time(sdf.parse(begin_time).getTime());
				userEntity.setEnd_time(sdf.parse(end_time).getTime());

			} else if (!begin_time.equals(end_time) && !begin_time.equals("0") && !end_time.equals("0")) {// 开始日期和结束日期不同
				String[] timeArray = end_time.split("-");
				if (timeArray[1].equals("12")) {
					int year = Integer.valueOf(timeArray[0]) + 1;
					int month = 01;
					end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					begin_time = begin_time + "-01 00:00:00";
				} else {
					int year = Integer.valueOf(timeArray[0]);
					int month = Integer.valueOf(timeArray[1]) + 1;
					if(month<10){//月份小与10 则默认补充0
						end_time = String.valueOf(year) + "-0" + String.valueOf(month) + "-01 00:00:00";
					}else{
						end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					}
					//end_time = String.valueOf(year) + "-" + String.valueOf(month) + "-01 00:00:00";
					begin_time = begin_time + "-01 00:00:00";

				}
				userEntity.setBegin_time(sdf.parse(begin_time).getTime());// 开始日期格式转成时间戳
				// 并注入
				userEntity.setEnd_time(sdf.parse(end_time).getTime());// 结束日期格式转成时间戳
				// 并注入
			} else {// 不选日期格式 默认
				userEntity.setBegin_time(0);
				userEntity.setEnd_time(0);
			}
			System.out.println("打印时间格式" + begin_time + "," + end_time);

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String if_duty = request.getParameter("if_duty");// 是否当班类型
			if (if_duty.equals("-1")) {
				userEntity.setIf_duty(null);
			} else {
				userEntity.setIf_duty(Integer.valueOf(if_duty));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			String source_type = request.getParameter("source_type");// 课程来源
			if (source_type.equals("0")) {
				userEntity.setSource_type(null);
			} else {
				userEntity.setSource_type(Integer.valueOf(source_type));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<UserInformationEntity> list = userInformationMapper.selectExportDuty(userEntity);// 更新用户信息表user_information
		// Integer num =
		// userService.updateUserConsultservice(userConsultServiceEntity);
		if (list.size() > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setData(list);
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;
	}
}
