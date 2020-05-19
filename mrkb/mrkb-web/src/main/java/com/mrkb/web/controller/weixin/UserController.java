package com.mrkb.web.controller.weixin;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mrkb.dao.dao.BasicUserMapper;
import com.mrkb.dao.dao.UserRecommendMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrkb.common.util.ResponseCode;
import com.mrkb.common.util.ResponseData;
import com.mrkb.common.utils.publicUtil;
import com.mrkb.common.utils.encryption.NameReach;
import com.mrkb.common.utils.paycomme.WeixinOauth2Token;
import com.mrkb.common.utils.weixinservice.WeixinUserInfoService;
import com.mrkb.dao.dao.UserInformationMapper;
import com.mrkb.dao.modle.Path.WebUrl;
import com.mrkb.dao.modle.user.BasicsUser;
import com.mrkb.dao.modle.user.UserAchievement;
import com.mrkb.dao.modle.user.UserConsultServiceEntity;
import com.mrkb.dao.modle.user.UserGrade;
import com.mrkb.dao.modle.user.UserInformationEntity;
import com.mrkb.dao.modle.user.UserIntegral;
import com.mrkb.dao.modle.user.UserRecommend;
import com.mrkb.dao.modle.user.UserTeamEntity;
import com.mrkb.dao.modle.user.UserWeixin;
import com.mrkb.dao.modle.weixin.oauth.SNSUserInfo;
import com.mrkb.dao.modle.weixin.often.WeiXinConfig;
import com.mrkb.service.UserDutyService;
import com.mrkb.service.UserService;
import com.mrkb.shiro.cookieutil.SessionEntity;

@Controller("weixin/user_weixin")
@RequestMapping("/weixin/user_weixin")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private UserDutyService userDutyService;
	@Autowired
	private UserInformationMapper userInformationMapper;
	@Autowired
	private BasicUserMapper basicUserMapper;
	@Autowired
	private UserRecommendMapper userRecommendMapper;


	/**
	 * 用户登陆，如果无该用户，有推荐人则注册，无推荐人不注册
	 *
	 * @param request
	 * @param jsonData
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@SuppressWarnings("unused")
	@ResponseBody
	@RequestMapping("findUserWeixin")
	public ResponseData findUserWeixin(HttpServletResponse response, HttpServletRequest request,
									   @RequestBody Map<String, Object> jsonData, HttpSession httpSession) {
		ResponseData rs = new ResponseData();

		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String user_basics = null;
		String weixin_id = null;
		try {
			weixin_id = jsonData.get("weixin_id").toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		BasicsUser bu1 = new BasicsUser();
		UserWeixin uw = new UserWeixin();// 用户微信信息
		uw.setWeixin_id(weixin_id);
		String user_basics_id = null;
		bu1 = userService.findUserWeixin(uw);
		String user_grade_id = null;// 会员等级
		try {
			if (bu1 == null) {// 无该用户
				rs.setMessage("未注册不能登陆！");
				rs.setIsSuccess(false);
				return rs;

			} else {
				user_basics_id = bu1.getUser_basics_id().toString();
				user_grade_id = bu1.getUser_grade_id().toString();
				rs.setData(bu1);
				rs.setMessage(NameReach.reach(user_basics_id));
				rs.setIsSuccess(true);
			}

		} catch (Exception e) {
			System.out.println("登陆失败");
			// BasicsUserData basicsUserData = new BasicsUserData();
			rs.setIsSuccess(false);
			rs.setMessage("登陆失败！");
			// vui.setBasicsUserData(basicsUserData);
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("user_basics_id", user_basics_id);
		map.put("weixin_id", weixin_id);
		map.put("user_grade_id", user_grade_id);
		Subject currentUser = SecurityUtils.getSubject();
		// currentUser.getSession().getAttribute("LOGINUSER");
		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		int ifcookie = 0;
		Cookie cookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("cookieName")) {// 判断是否有cookieName
					ifcookie = 1;
					HttpSession sess = request.getSession();
					if (cookies[i].getValue() != null && cookies[i].getValue() == "") {// 未设置cookie
						// if
						// (sess.getAttribute(cookies[i].getValue()).equals("")

						// || sess.getAttribute(cookies[i].getValue()) == null)
						// {// 判断是否有session，session为空
						if (currentUser.getSession().getAttribute(cookies[i].getValue()).equals("")
								|| currentUser.getSession().getAttribute(cookies[i].getValue()) == null) {
							session.setAttribute(user_basics_id, map);// 存session
							session.setMaxInactiveInterval(31 * 60);
							cookies[i].setValue(NameReach.reach(user_basics_id));
							String i1 = NameReach.reach(user_basics_id);
							// ifcookie=0;
						}
					} else {// 已设置cookname
						session.setAttribute(user_basics_id, map);
						session.setMaxInactiveInterval(31 * 60);
						cookies[i].setValue(NameReach.reach(user_basics_id));
						// String i1=NameReach.reach(user_basics_id);
						// ifcookie=0;
					}

				}
			}

		}

		if (ifcookie == 0) {
			cookie = new Cookie("cookieName", NameReach.reach(user_basics_id));
			cookie.setPath("/");
			cookie.setMaxAge(60 * 30);
			response.addCookie(cookie);
			session.setAttribute(user_basics_id, map);
			session.setMaxInactiveInterval(31 * 60);

		}
		Integer user_basics_id1 = Integer.valueOf(user_basics_id);
		UserWeixin bu2 = userService.findUserWeixinUserBasicsId(user_basics_id1);// 通过微信信息查找用户
		String weixin_nickname = String.valueOf(jsonData.get("nickname"));// 微信昵称
		int state = 1;
		// 微信头像不为空 weixin_portrait
		String weixin_portrait = String.valueOf(jsonData.get("headImgUrl"));// 微信头像
		if (weixin_portrait != null && !weixin_portrait.equals("null") && !weixin_portrait.equals("")) {// 前端已传入微信id
			if (bu2.getWeixin_nickname() == null) {// 用户微信数据不包含微信昵称
				state = 0;
			} else if (!bu2.getWeixin_nickname().equals(weixin_portrait)) {// 用户微信昵称未发生改变
				state = 0;
			}
			if (state == 0) {
				UserWeixin userWeixin = new UserWeixin();
				userWeixin.setUser_basics_id(Integer.valueOf(user_basics_id));
				userWeixin.setWeixin_portrait(weixin_portrait);
				userService.editUserWeixin(userWeixin);// 修改用户微信昵称
			}

		}
		// 微信昵称不为空
		if (weixin_nickname != null && !weixin_nickname.equals("null") && !weixin_nickname.equals("")) {// 前端已传入微信id
			if (bu2.getWeixin_nickname() == null) {// 用户微信数据不包含微信昵称
				state = 0;
			} else if (!bu2.getWeixin_nickname().equals(weixin_nickname)) {// 用户微信昵称未发生改变
				state = 0;
			}
			if (state == 0) {
				UserWeixin userWeixin = new UserWeixin();
				userWeixin.setUser_basics_id(Integer.valueOf(user_basics_id));
				userWeixin.setWeixin_nickname(weixin_nickname);
				try {
					userService.editUserWeixin(userWeixin);// 修改用户微信昵称
				} catch (Exception e) {
					String patternString = "([\\x{10000}-\\x{10ffff}\\ud800-\\udfff])";
					Pattern pattern = Pattern.compile(patternString);
					Matcher matcher = pattern.matcher(weixin_nickname);
					StringBuffer sb = new StringBuffer();
					while (matcher.find()) {
						try {
							matcher.appendReplacement(sb, "[[" + URLEncoder.encode(matcher.group(1), "UTF-8") + "]]");
						} catch (UnsupportedEncodingException e2) {
							e2.printStackTrace();
						}
					}
					matcher.appendTail(sb);
					weixin_nickname = sb.toString();
					userWeixin.setWeixin_nickname(weixin_nickname);
					userService.editUserWeixin(userWeixin);// 修改用户微信昵称
				}

			}

		}
		return rs;
	}

	/**
	 * 更改用户微信信息
	 *
	 * @param response
	 * @param request
	 * @param jsonData
	 * @param httpSession
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("updateUserWeixin")
	public ResponseData updateUserWeixin(HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		String user_weixin_id = request.getParameter("user_weixin_id");// 微信id
		String weixin_id = request.getParameter("weixin_id");// 微信id
		String weixin_portrait = request.getParameter("weixin_portrait");// 微信头像
		String weixin_nickname = request.getParameter("weixin_nickname");// 微信昵称
		String weixin_gender = request.getParameter("weixin_gender");// 微信性别
		String weixin_follow_choice = request.getParameter("weixin_follow_choice");// 是否关注
		String weixin_follow_data_yes = request.getParameter("weixin_follow_data_yes");// 关注时间
		String weixin_follow_data_no = request.getParameter("weixin_follow_data_no");// 取消关注时间
		String user_basics_id = request.getParameter("user_basics_id");// 用户关联user表自增ID
		String share_img = request.getParameter("share_img");// 用户分享二维码
		String share_img_dated = request.getParameter("share_img_dated");// 用户分享二维码过期日期
		UserWeixin userWeixin = new UserWeixin();
		if (weixin_id != null && !weixin_id.equals("null")) {
			userWeixin.setWeixin_id(weixin_id);
		}
		if (weixin_portrait != null && !weixin_portrait.equals("null")) {
			userWeixin.setWeixin_portrait(weixin_portrait);
		}
		if (weixin_nickname != null && !weixin_nickname.equals("null")) {
			userWeixin.setWeixin_nickname(weixin_nickname);
		}
		if (weixin_gender != null && !weixin_gender.equals("null")) {
			userWeixin.setWeixin_gender(Integer.valueOf(weixin_gender));
		}
		;
		if (weixin_follow_choice != null && !weixin_follow_choice.equals("null")) {
			userWeixin.setWeixin_follow_choice(Integer.valueOf(weixin_follow_choice));
		}
		;
		if (weixin_follow_data_yes != null && !weixin_follow_data_yes.equals("null")) {
			userWeixin.setWeixin_follow_data_yes(Long.valueOf(weixin_follow_data_yes));
		}
		;
		if (weixin_follow_data_no != null && !weixin_follow_data_no.equals("null")) {
			userWeixin.setWeixin_follow_data_no(Long.valueOf(weixin_follow_data_no));
		}
		;
		if (user_basics_id != null && !user_basics_id.equals("null")) {
			userWeixin.setUser_basics_id(Integer.valueOf(user_basics_id));
		}
		;
		if (share_img != null && !share_img.equals("null")) {
			userWeixin.setShare_img(share_img);
		}
		;

		if (share_img_dated != null && !share_img_dated.equals("null")) {
			userWeixin.setShare_img_dated(Long.valueOf(share_img_dated));
		}
		;
		int update = userService.editUserWeixin(userWeixin);
		if (update > 0) {
			rs.setIsSuccess(true);
			rs.setMessage("修改成功！");
			return rs;
		} else {
			rs.setIsSuccess(false);
			rs.setMessage("修改失败！");
			return rs;
		}

	}

	/**
	 * 查询用户微信信息
	 *
	 * @param response
	 * @param request
	 * @param jsonData
	 *            包含用户微信id 对应字段weixin_id
	 * @param httpSession
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("findUserWeixinWinxinId")
	public ResponseData findUserWeixinWinxinId(HttpServletRequest request) {
		ResponseData rs = new ResponseData();

		String weixin_id = request.getParameter("weixin_id");// 用户微信id
		UserWeixin userWeixin = userService.findUserWeixin(weixin_id);

		if (userWeixin != null) {
			rs.setIsSuccess(true);
			rs.setData(userWeixin);
			rs.setMessage("返回用户微信信息成功");
		} else {
			rs.setIsSuccess(false);
			rs.setMessage("返回用户微信信息失败！");
		}
		return rs;
	}

	/**
	 * 方法: weixindoGet 描述:
	 * 来自微信的请求，get请求的参数是code、state，这里我需要在菜单那里配置即可，也就是用户点击按钮，然后微信访问该方法 开发人员： 万祖权
	 * 创建时间： 2018-1-1
	 *
	 * @return
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("weixindoGet")
	public void weixindoGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setCharacterEncoding("utf-8");
		// 用户同意授权后，能获取到code，如果在微信公众号内，不需要用户同意，是一种无感觉的授权，也就是默认授权
		String code = request.getParameter("code");// 微信授权请求码
		String state = request.getParameter("state");// 是自定义参数，用了判断跳到指定的页面，官方文档说明是，重定向后会带上state参数，开发者可以填写a-zA-Z0-9的参数值，最多128字节
		String zdy = request.getParameter("zdy");

		if (state == null || code == null || code.length() <= 0) {// code为设置，对应公众号（会员中心)按钮

			// request.getRequestDispatcher("/HomeController/home").forward(request,
			// response);
			response.sendRedirect("/morekaba/weixin/HomeController/home");
			return;
		} else {

			// 用户同意授权
			SNSUserInfo snsUserInfo = null;
			if (!"authdeny".equals(code)) {// 如果用户不反对授权
				// 获取自己公众号的微信配置
				WeiXinConfig WeiXinConfig = new WeiXinConfig();
				// 获取网页授权access_token,这个与操作微信公众号的access_token不同
				WeixinOauth2Token weixinOauth2Token = WeixinUserInfoService.getOauth2AccessToken(WeiXinConfig.AppID,
						WeiXinConfig.AppSecret, code);
				if (weixinOauth2Token == null || weixinOauth2Token.equals("null")) {
					response.sendRedirect(WebUrl.DOMAIN + "morekaba/weixin/HomeController/home");
					return;
				}
				// 网页授权接口访问凭证
				String accessToken = weixinOauth2Token.getAccessToken();
				// 用户标识
				String openId = weixinOauth2Token.getOpenId();
				// 获取用户信息,是那些字段，详情请看这个模型类SNSUserInfo，微信官方文档说明字段如下：

				/**
				 * openid 用户的唯一标识 nickname 用户昵称 sex
				 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 province 用户个人资料填写的省份 city
				 * 普通用户个人资料填写的城市 country 国家，如中国为CN headimgurl
				 * 用户头像，最后一个数值代表正方形头像大小
				 * （有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空
				 * 。若用户更换头像，原有头像URL将失效。 privilege 用户特权信息，json
				 * 数组，如微信沃卡用户为（chinaunicom） unionid
				 * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
				 **/
				snsUserInfo = WeixinUserInfoService.getSNSUserInfo(accessToken, openId);
				String CreateTime = "1513153444888"; // formatTime(longTime);
				String EventKey = "o340P1hTZQNb3UhIkI54LPy6vT4Q";
				Map<String, Object> map1 = new HashMap<String, Object>();
				map1.put("weixin_id", snsUserInfo.getOpenId()); // 当前用户id
				map1.put("weixin_follow_data_yes", CreateTime); // 关注时间
				map1.put("headImgUrl", snsUserInfo.getHeadImgUrl()); // 头像
				map1.put("nickname", snsUserInfo.getNickname()); // 昵称
				HttpSession httpSession = null;
				ResponseData rs = null;
				try {
					map1.put("recommend_superior_winxin", EventKey); // 推荐人微信id
					rs = findUserWeixin(response, request, map1, httpSession);
				} catch (Exception e) {
					e.printStackTrace();
					rs.setIsSuccess(false);
				}
				/*
				 * SNSUserInfo snsUserInfo=new SNSUserInfo();
				 * snsUserInfo.setOpenId("5555555"); snsUserInfo.setSex(1);
				 * snsUserInfo.setHeadImgUrl("http");
				 * snsUserInfo.setNickname("我是名称"); snsUserInfo.setSex(1);
				 */
				/*
				 * UserWeixin uw=new UserWeixin();//用户微信信息
				 *
				 * uw.setWeixin_id(snsUserInfo.getOpenId());
				 * uw.setWeixin_portrait(snsUserInfo.getHeadImgUrl());
				 * uw.setWeixin_nickname(snsUserInfo.getNickname());
				 * uw.setWeixin_gender(snsUserInfo.getSex());//sex
				 * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
				 */
				// uw.setWeixin_follow_choice();
				// private Integer user_weixin_id;//自增id
				// private String weixin_id;//微信ids
				// private String weixin_portrait;//微信头像
				// private String weixin_nickname;//微信昵称
				// private Integer weixin_gender;//微信性别
				// private Integer weixin_follow_choice;//是否关注
				// private Double weixin_follow_data_yes;//关注时间
				// private Double weixin_follow_data_no;//取消关注时间
				// private Integer user_basics_id;//关联user表自增ID
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("weixin_id", snsUserInfo.getOpenId());
				map.put("weixin_portrait", snsUserInfo.getHeadImgUrl());
				map.put("weixin_nickname", snsUserInfo.getNickname());
				map.put("weixin_gender", snsUserInfo.getSex());
				// 写入用户信息
				// 设置要传递的参数,传到微信端，写入cooki，也就是用户登录状态
				request.setAttribute("snsUserInfo", snsUserInfo);
				request.setAttribute("state", "1");
				Cookie[] cookie = request.getCookies();
				Cookie getOpenId = new Cookie("getOpenId", snsUserInfo.getOpenId());
				getOpenId.setPath("/");
				Cookie getHeadImgUrl = new Cookie("getHeadImgUrl", snsUserInfo.getHeadImgUrl());
				getHeadImgUrl.setPath("/");
				Cookie getNickname = null;
				publicUtil pc = new publicUtil();
				getNickname = new Cookie("getNickname", snsUserInfo.getNickname().toString().replace(" ", "-"));

				// Cookie getNickname = new
				// Cookie("getNickname",SNSUserInfo.getNickname());
				getNickname.setPath("/");
				response.addCookie(getOpenId);
				response.addCookie(getHeadImgUrl);
				response.addCookie(getNickname);

				// }

			}
			if (state.equals("home")) {

				// }
				// 跳转到index.jsp，在这里可以判断state的值跳到指定的页面，页面地址不变
				try {
					// request.getRequestDispatcher("/morekaba/HomeController/home").forward(request,
					// response);
					System.out.print(snsUserInfo.getOpenId());
					String weixin_id=snsUserInfo.getOpenId();
					UserWeixin uw=new UserWeixin();
					uw.setWeixin_id(weixin_id);
					UserInformationEntity ue=basicUserMapper.findUserInfo(uw);
					if(ue!=null){
						if(ue.getInformation_compellation()==null||ue.getInformation_compellation().equals("")||ue.getInformation_compellation().equals("null")){
							response.sendRedirect("/morekaba/weixin/HomeController/questionnaire");
						}else{
							response.sendRedirect("/morekaba/weixin/HomeController/home");
						}
					}else{
						response.sendRedirect("/morekaba/weixin/HomeController/home");
					}



				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (state.equals("qrcod")) {
				// 页面地址改变,页面地址改变后可以分享该网页到，朋友圈
				try {
					response.sendRedirect("/morekaba/weixin/QRcodeController/getQRcode?openid=" + snsUserInfo.getOpenId());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// request.getRequestDispatcher(").forward(request, response);

			} else {

				// 页面地址不变,反正不是HomeController/home地址，内容却是/HomeController/home的
				try {
					response.sendRedirect("/morekaba/weixin/HomeController/home");
					// request.getRequestDispatcher("/HomeController/home").forward(request,
					// response);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
		// request.getRequestDispatcher("/QRcodeController/getQRcode?openidd="+snsUserInfo.getOpenId()).forward(request,
		// response);

	}

	/**
	 * 查询用户推荐人基本信息
	 *
	 * @param response
	 * @param request
	 * @param jsonData
	 * @return
	 */
	@ResponseBody
	@RequestMapping("findUserSuperioruserUserBasics")
	public ResponseData findUserSuperioruserUserBasics(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		String user_basics = null;
		// TODO Auto-generated catch block
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);
		} catch (SessionException e) {
			e.printStackTrace();
		}
		Object ma = request.getSession().getAttribute(user_basics);
		HashMap<String, Object> map2 = (HashMap) ma;
		String user_basics_id;// 用户id
		user_basics_id = String.valueOf(sessionEntity.getUser_basics_id());

		String round = request.getParameter("round");// 推荐人的级数
		if (round.equals("null") || round == null) {
			round = "1";
		}
		// 执行servise执行查询返回UserRecommend实体类

		UserRecommend ur = userService.findUserSuperiorUserid(sessionEntity.getUser_basics_id(),
				Integer.valueOf(round));
		UserWeixin uw = null;
		if (ur != null) {
			Integer q = Integer.valueOf(String.valueOf(ur.getRecommend_superior()));
			uw = userService.findUserWeixinUserBasicsId(Integer.valueOf(String.valueOf(ur.getRecommend_superior())));
			String weixin_nickname = uw.getWeixin_nickname();
			publicUtil pc = new publicUtil();
			weixin_nickname = pc.emojiRecovery(weixin_nickname);
			uw.setWeixin_nickname(weixin_nickname);
		}
		rs.setData(uw);
		rs.setIsSuccess(true);
		return rs;

	}

	/**
	 *
	 * @Title: findUserSubordinateInculdeOrderBasics @Description: TODO
	 *         查询用户下属三级，包含下级订单信息 @param: @param response @param: @param
	 *         request @param: @return @return: VisitConsequenceParent @throws
	 */
	@ResponseBody
	@RequestMapping("findUserSubordinateInculdeOrderBasics")
	public ResponseData findUserSubordinateInculdeOrderBasics(HttpServletResponse response,
															  HttpServletRequest request) {// 查询用户下级，包含下级订单信息
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);// 获取用户session
		} catch (SessionException e) {
			rs.setIsSuccess(false);
			return rs;
		}
		Map<String, List<UserTeamEntity>> subordinateMap = userService.findUserTeamSubordinateIncludeOrderBasics(3,
				sessionEntity.getUser_basics_id());// 查询推荐的下级团队，级数为3
		Iterator entries = subordinateMap.entrySet().iterator();
		publicUtil uc = new publicUtil();

		while (entries.hasNext()) {
			List<UserTeamEntity> value = null;
			String key = "";
			Map.Entry entry = (Map.Entry) entries.next();
			key = String.valueOf(entry.getKey());
			value = (List<UserTeamEntity>) entry.getValue();
			if (value != null) {
				for (int i = 0; i < value.size(); i++) {
					UserTeamEntity ue = value.get(i);
					String superior_weixin_nickname = ue.getSuperior_weixin_nickname();
					superior_weixin_nickname = uc.emojiRecovery(superior_weixin_nickname);
					value.get(i).setSuperior_weixin_nickname(superior_weixin_nickname);
					String weixin_nickname = ue.getWeixin_nickname();
					weixin_nickname = uc.emojiRecovery(weixin_nickname);
					value.get(i).setWeixin_nickname(weixin_nickname);
				}
			}
			subordinateMap.put(key, value);
		}

		rs.setData(subordinateMap);
		rs.setIsSuccess(true);
		return rs;

	}

	@RequestMapping("denglu")
	public String denglu(HttpServletRequest request) {
		return "index";

	}

	/**
	 *
	 * @Title: findUserSubordinateInculdeOrderBasics @Description: TODO
	 *         查询用户下属三级，包含下级订单信息 @param: @param response @param: @param
	 *         request @param: @return @return: VisitConsequenceParent @throws
	 */
	@ResponseBody
	@RequestMapping("findUserSubordinateInculdeOrderBasics5")
	public ResponseData findUserSubordinateInculdeOrderBasics5(HttpServletResponse response,
															   HttpServletRequest request) {// 查询用户下级，包含下级订单信息
		ResponseData rs = new ResponseData();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);// 获取用户session
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		Map<String, List<UserTeamEntity>> subordinateMap = userService.findUserTeamSubordinateIncludeOrderBasics(3,
				sessionEntity.getUser_basics_id());// 查询推荐的下级团队，级数为3
		rs.setData(subordinateMap);
		rs.setIsSuccess(true);
		return rs;

	}

	/**
	 *
	 * @Title: findUserGrade @Description: TODO 查询单个会员等级信息 @param: @param
	 *         response @param: @param request
	 *         包含json对象，user_grade_id值代表会员等级 @param: @return @return:
	 *         UserGrade @throws
	 */
	@ResponseBody
	@RequestMapping("findUserGrade")
	public ResponseData findUserGrade(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();

		Integer user_grade_id = Integer.valueOf(request.getParameter("user_grade_id"));// 获取键为user_grade_id的值
		UserGrade userGrade = userService.findUserGrade(user_grade_id);
		rs.setData(userGrade);
		rs.setIsSuccess(true);
		return rs;

	}

	/**
	 *
	 * @Title: findUserGrade @Description: TODO 修改单个用户信息 @param: @param
	 *         response @param: @param request 包含json对象 @param: @return @return:
	 *         UserGrade @throws
	 */

	@ResponseBody
	@RequestMapping("updateUserInformation")
	public ResponseData updateUserInformation(HttpServletResponse response, HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResponseData rs = new ResponseData();
		// String jsonStr=JsonUtils.getJsonStr(request);//鑾峰彇鍓嶇鎻愪氦鐨刯son鏁版嵁
		// 骞惰浆鎹负json瀛楃涓�
		// JSONObject
		// json=JSONObject.fromString(jsonStr);//灏嗗瓧绗︿覆杞崲涓篔SONObject瀵硅薄
		UserInformationEntity uie = new UserInformationEntity();
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);// 鑾峰彇鐢ㄦ埛session
		} catch (SessionException e) {
			rs.setIsSuccess(false);
			return rs;
		}
		Integer user_basics_id = sessionEntity.getUser_basics_id();
		uie.setUser_basics_id(user_basics_id);
		try {
			String information_phone = String.valueOf(request.getParameter("information_phone"));
			if (information_phone != null && information_phone != "null") {
				uie.setInformation_phone(information_phone);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String information_qq = String.valueOf(request.getParameter("information_qq"));
			if (information_qq != null && information_qq != "null") {
				uie.setInformation_qq(information_qq);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String information_Email = String.valueOf(request.getParameter("information_Email"));
			if (information_Email != null && information_Email != "null") {
				uie.setInformation_Email(information_Email);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String information_compellation = String.valueOf(request.getParameter("information_compellation"));
			if (information_compellation != null && information_compellation != "null") {
				uie.setInformation_compellation(information_compellation);// 鐪熸槸濮撳悕
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String information_card = String.valueOf(request.getParameter("information_card"));
			if (information_card != null && information_card != "null") {
				uie.setInformation_card(information_card);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String card_end = String.valueOf(request.getParameter("card_end"));
			if (card_end != null && card_end != "null") {
				uie.setCard_end(card_end);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Integer information_sex = Integer.valueOf(String.valueOf(request.getParameter("information_sex")));
			if (information_sex != null) {
				uie.setInformation_sex(information_sex);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String nick_name = String.valueOf(request.getParameter("nick_name"));
			if (nick_name != null && nick_name != "null") {
				uie.setNick_name(nick_name);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String live_address = String.valueOf(request.getParameter("live_address"));
			if (live_address != null && live_address != "null") {
				uie.setLive_address(live_address);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String registered_address = String.valueOf(request.getParameter("registered_address"));
			if (registered_address != null && registered_address != "null") {
				uie.setRegistered_address(registered_address);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String information_weixin = String.valueOf(request.getParameter("information_weixin"));
			if (information_weixin != null && information_weixin != "null") {
				uie.setInformation_weixin(information_weixin);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String card_picture = String.valueOf(request.getParameter("card_picture"));
			if (card_picture != null && card_picture != "null") {
				uie.setCard_picture(card_picture);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			Integer information_age = Integer.valueOf(String.valueOf(request.getParameter("information_age")));
			if (information_age != null) {
				uie.setInformation_age(information_age);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String identityCard_img1 = String.valueOf(request.getParameter("identityCard_img1"));
			if (identityCard_img1 != null) {
				uie.setIdentityCard_img1(identityCard_img1);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			String identityCard_img2 = String.valueOf(request.getParameter("identityCard_img2"));
			if (identityCard_img2 != null) {
				uie.setIdentityCard_img2(identityCard_img2);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		Integer updatenul = userService.updateUserInformation(uie);
		if (updatenul != 0) {
			rs.setIsSuccess(true);
			return rs;
		} else {
			rs.setIsSuccess(false);
			return rs;
		}

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
		// String jsonStr=JsonUtils.getJsonStr(request);//获取前端提交的json数据
		// 并转换为json字符串
		// JSONObject json=JSONObject.fromString(jsonStr);//将字符串转换为JSONObject对象
		SessionEntity sessionEntity = null;
		try {
			sessionEntity = new SessionEntity(request);// 获取用户session
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			rs.setIsSuccess(false);
			return rs;
		}
		Integer user_basics_id = sessionEntity.getUser_basics_id();
		UserInformationEntity uie = userService.findUserInformation(user_basics_id);
		if (uie != null) {
			rs.setData(uie);
			rs.setIsSuccess(true);
		} else {
			rs.setIsSuccess(false);
		}

		return rs;
	}

	/**
	 *
	 * @Title: findAllUserGrade @Description: TODO 查询会员等级 @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         ResponseData @throws
	 */
	@ResponseBody
	@RequestMapping("findAllUserGrade")
	public ResponseData findAllUserGrade(HttpServletRequest req) {
		ResponseData R = new ResponseData();
		// List<UserGrade>userGradeList=userService.findAllGrade();//查询会员等级
		String userName = req.getParameter("name");//
		// PageHelper.startPage(pageNum, pageSize);
		List<UserGrade> userGradeList = userService.findAllGrade();// 查询会员等级
		// PageInfo<UserGrade> PageInfo = new PageInfo<>(userGradeList);
		if (userGradeList != null && userGradeList.size() > 0) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setData(userGradeList);
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;

	}

	/**
	 *
	 * @Title: finduserBasics @Description: TODO 查询单个会员 @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         ResponseData @throws
	 */
	@ResponseBody
	@RequestMapping("findUserWeixinOne")
	public ResponseData findUserWeixinOne(HttpServletRequest req) {
		ResponseData R = new ResponseData();
		String weixin_id = req.getParameter("weixin_id");//
		UserWeixin uw = new UserWeixin();
		uw.setWeixin_id(weixin_id);
		BasicsUser bu = userService.findUserWeixin(uw);// 查询单个会员
		if (bu != null) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setData(bu);
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;

	}

	/**
	 *
	 * @Title: findUserConsultServiceByUserId @Description: TODO
	 *         查询我的顾问 @param: @param response @param: @param
	 *         request @param: @return @return: ResponseData @throws
	 */
	@ResponseBody
	@RequestMapping("findUserConsultServiceByUserId")
	public ResponseData findUserConsultServiceByUserId(HttpServletRequest req) {
        ResponseData R = new ResponseData();
        SessionEntity se = null;
        try {
            se = new SessionEntity(req);
        } catch (SessionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Integer user_basics_id = 0;
        try {
            user_basics_id = se.getUser_basics_id();
        } catch (Exception e) {
            R.setIsSuccess(false);
            return R;
        }
        String advisorName = null;// 乐唐顾问
        String advisorPhone = null;// 乐唐顾问联系方式
        String seniorManagerName = "";// 高级经理
        String seniorManagerPhone = "";// 高级经理联系方式
        // 根据用户id查询乐唐顾问id，高级经理id/
        UserConsultServiceEntity entity = new UserConsultServiceEntity();// 创我的顾问实体
        entity.setUser_basics_id(user_basics_id);
        // 根据用户id查询用户等级
        BasicsUser userEntity = userService.finduserBasics(user_basics_id);
        // 获取用户等级id
        Integer gradeId = userEntity.getUser_grade_id();
        // 获取用户等级信息
        UserGrade userGrade = userService.findUserGrade(gradeId);
        String gradeNickname = userGrade.getGrade_nickname();

        UserConsultServiceEntity userConsultServiceEntity = userService.findUserConsultserviceById(entity);

        if (userConsultServiceEntity != null) {
            seniorManagerName=userConsultServiceEntity.getSenior_manager_name();
            seniorManagerPhone=userConsultServiceEntity.getSenior_manager_phone();
        }
        // 获取乐唐顾问
        UserInformationEntity user2 = userService.findUserInformation(user_basics_id);
        UserInformationEntity user1 = userService.findUserInformation(user2.getCo_user_basics_id());
        if (user1 != null) {
            advisorName = user1.getInformation_compellation();// 真实姓名
            if (advisorName == null || advisorName.equals("")) {// 判断用户是否存在
                advisorName = "未实名认证";
            }
            advisorPhone = user1.getInformation_phone();// 电话号码
            if (advisorPhone == null || advisorPhone.equals("")) {// 判断用户是否存在
                advisorPhone = "未知";
            }
        } else {
            advisorName = "无";
            advisorPhone = "无";
        }


        /* 我的顾问数据封装 */

        Map<String, Object> map1 = new HashMap<String, Object>();
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map3 = new HashMap<String, Object>();
        map1.put("advisorName", advisorName);
        map1.put("advisorPhone", advisorPhone);
        map1.put("type", 1);
        map1.put("weixin_portrait",user1.getWeixin_portrait());
        map2.put("seniorManagerName", seniorManagerName);
        map2.put("seniorManagerPhone", seniorManagerPhone);
        map2.put("type", 2);
        map3.put("advisor", map1);
        map3.put("seniorManager", map2);
        map3.put("gradeNickname", gradeNickname);
        R.setErrorCode(ResponseCode.SUCC_DO.getCode());
        R.setMessage(ResponseCode.SUCC_DO.getMsg());
        R.setData(map3);
        return R;
    }

	/**
	 *
	 * @Title: findUserAchievement @Description: 查询用户未激活快乐豆 @param
	 *         response @param: @param request @param: @return @return:
	 *         ResponseData @throws
	 */
	@ResponseBody
	@RequestMapping("findUserAchievement")
	public ResponseData findUserAchievement(HttpServletRequest req) {
		ResponseData R = new ResponseData();
		int courseCount = 0;// 已经当班课程统计数量总和初始化
		int kldAwardCount = 0;// 我的快乐豆奖励总和
		int myTeamCount = 0;// 我的下属总人数
		int myTeamKldAwardCount = 0;// 下属团队于我赢得的快乐豆奖励总和
		UserAchievement userAchievement2 = null;
		UserInformationEntity userInfo = null;
		UserIntegral userIntegral1 = null;
		UserWeixin uWeixin = new UserWeixin();
		HashMap<String, Object> map = new HashMap<String, Object>();
		SessionEntity se = null;
		Integer user_basics_id = 0;//用户id
		try {
			se = new SessionEntity(req);
		} catch (SessionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			user_basics_id = se.getUser_basics_id();
		} catch (Exception e) {
			R.setIsSuccess(false);
			return R;
		}
		// 1.查询用户未激活的快乐豆,历史快乐豆总和
		UserAchievement userAchievement = userService.findUserAchievement(user_basics_id);
		// 2.查询用户可用快乐豆
		UserIntegral userIntegral = userService.findUserIntegral(user_basics_id);
		// 3.查询我的当班 课程总数 ，及快乐豆奖励查询(未激活快乐豆+已激活快乐豆的总和)
		courseCount = userDutyService.countDuty(user_basics_id);
		kldAwardCount = userAchievement.getIntegral_no_active() + userIntegral.getIntegral_basics();
		// 4.我的下属总人数 及 给我带来的快乐豆(未激活快乐豆+已激活快乐豆的总和)
		Map<String, List<UserTeamEntity>> subordinateMap = userService.findUserTeamSubordinateIncludeOrderBasics(1,
				user_basics_id);// 查询推荐的下级团队，级数为1

		Iterator entries = subordinateMap.entrySet().iterator();
		while (entries.hasNext()) {
			List<UserTeamEntity> value = null;
			String key = "";
			Map.Entry entry = (Map.Entry) entries.next();
			key = String.valueOf(entry.getKey());
			value = (List<UserTeamEntity>) entry.getValue();
			if (value != null) {
				for (int i = 0; i < value.size(); i++) {
					UserTeamEntity ue = value.get(i);
					// 获取下属用户id
					// 1.查询该用户的未激活积分，未激活快乐豆
					userAchievement2 = userService.findUserAchievement(ue.getUser_basics_id());
					value.get(i).setIntegral_no_activce(userAchievement2.getIntegral_no_active());// 未激活快乐豆
					value.get(i).setIntegrals_no_activce(userAchievement2.getIntegrals_no_active());// 未激活积分
					// 2.查询用户的真实姓名及联系方式
					userInfo = userService.findUserInformation(ue.getUser_basics_id());
					if(userInfo == null){
						value.get(i).setInformation_compellation("无");
						value.get(i).setInformation_phone("无");
					}else{
						value.get(i).setInformation_compellation(userInfo.getInformation_compellation());
						value.get(i).setInformation_phone(userInfo.getInformation_phone());
					}

					// 3.查询用户已激活快乐豆
					userIntegral1 = userService.findUserIntegral(ue.getUser_basics_id());
					myTeamKldAwardCount += userIntegral1.getIntegral_basics();
					myTeamCount++;
				}
			}

			subordinateMap.put(key, value);
		}

		map.put("userAchievement", userAchievement);// integral_no_active();未激活快乐豆,records_integral();快乐豆总数
		map.put("userIntegral", userIntegral);// userIntegral.getIntegral_basics();可使用快乐豆
		map.put("courseCount", courseCount);// 我的当班 课程总数
		map.put("kldAwardCount", kldAwardCount);// 快乐豆奖励
		map.put("myTeamCount", myTeamCount);// 我的下属团队人数
		map.put("myTeamKldAwardCount", myTeamKldAwardCount);// 我的下属团队快乐豆总数
		map.put("subordinateMap", subordinateMap);// 获取下属团队列表
		if (userAchievement != null) {
			R.setErrorCode(ResponseCode.SUCC_DO.getCode());
			R.setMessage(ResponseCode.SUCC_DO.getMsg());
			R.setData(map);
			return R;
		}
		R.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
		R.setMessage(ResponseCode.ERROR_FAIL.getMsg());
		return R;

	}
	@ResponseBody
	@RequestMapping("findUserInfoById")
	public ResponseData findUserInfoById(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		Integer user_basics_id = Integer.valueOf(String.valueOf(request.getParameter("user_basics_id")));
		// String jsonStr=JsonUtils.getJsonStr(request);//获取前端提交的json数据
		// 并转换为json字符串
		// JSONObject json=JSONObject.fromString(jsonStr);//将字符串转换为JSONObject对象
		UserInformationEntity uie = userService.findUserInformation(user_basics_id);
		if (uie != null) {
			rs.setData(uie);
			rs.setErrorCode(ResponseCode.SUCC_DO.getCode());
			rs.setMessage("用户编号存在!");
			return rs;
		} else {
			rs.setErrorCode(ResponseCode.ERROR_FAIL.getCode());
			rs.setMessage("用户编号不存在！");
			return rs;
		}
	}
	/**
	 *
	 * @Title: addSignIntegral @Description: 新增签到积分 @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         VisitConsequenceParent @throws
	 */

	// @ResponseBody
	// @RequestMapping("addSignIntegral")
	// public ResponseData addSignIntegral(
	// HttpServletResponse response,HttpServletRequest request,@RequestBody
	// Map<String,Object>json) {
	// ResponseData rs = new ResponseData();
	// /*初始化实体对象*/
	// SignIntegralEntity signIntegralEntity = new SignIntegralEntity();
	// SignIntegralEntity signIntegralEntity1 = new SignIntegralEntity();
	// SessionEntity sessionEntity=null;//初始化
	// long sign_date = 0l;//签到日期初始化
	// Integer sign_num = 0;//签到积分初始化
	// String signDate1 = null;//数据库查询某一用户签到最大时间戳
	// String signDate = null;//前端传入签到时间戳参数
	// SignIntegralEntity signIntegralEntity2 = null;//数据返回初始化
	// SignIntegralEntity signIntegralEntity3 = null;//数据返回初始化
	// try {
	// sessionEntity = new SessionEntity(request);//获取用户session
	// } catch (SessionException e) {
	// rs.setIsSuccess(false);
	// return rs;
	// }
	// try {
	// sign_date = Long.parseLong(String.valueOf(json.get("sign_date")));
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// try {
	// sign_num = Integer.valueOf(GlobalStatic.sign_num);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// /*将前端返回的参数注入到signIntegralEntity实体对象中*/
	// signIntegralEntity.setSign_date(sign_date);
	// signIntegralEntity.setSign_num(sign_num);
	// signIntegralEntity.setUser_basics_id(sessionEntity.getUser_basics_id());//获取用户id
	// 并注入到signIntegralEntity实体对象中
	// signIntegralEntity1.setUser_basics_id(sessionEntity.getUser_basics_id());//获取用户id
	// 并注入到signIntegralEntity实体对象中
	// SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd ");
	// /*前端传入参数*/
	// signDate =simpleDateFormat.format(sign_date*1000);
	// /*数据库查找最大时间戳*/
	// SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd ");
	// /*查询某一用户签到最大时间戳*/
	// signIntegralEntity3 =
	// signIntegralService.findMaxTimeStamp(signIntegralEntity1);
	// System.out.println("数据查询结果++"+signIntegralService.findMaxTimeStamp(signIntegralEntity1));
	// if(signIntegralEntity3 == null){
	// rs.setIsSuccess(false);
	// }else{
	// signDate1
	// =simpleDateFormat1.format(signIntegralEntity3.getSign_date()*1000);
	// }
	// /*比较数据库某用户最大签到时间戳与这一用户此时签到时间戳进行比较，若相同则不能再新增签到，反之亦然*/
	// if(signDate.equals(signDate1)){
	// rs.setMessage("今日已经签到了");
	// rs.setIsSuccess(false);
	// }else{
	// /*签到新增操作*/
	// signIntegralEntity2 =
	// signIntegralService.addSignIntegral(signIntegralEntity);
	// if(signIntegralEntity2 != null){
	// vc.setObject(signIntegralEntity2);
	// vc.setMessage("签到成功");
	// vc.setState(0);
	// }else{
	// vc.setMessage("签到失败");
	// vc.setState(1);
	// }
	// }
	//
	// return vc;
	// }
	/**
	 *
	 * @Title: findAllSignIntegral @Description: 查询所有签到记录 @param: @param
	 *         response @param: @param request @param: @return @return:
	 *         VisitConsequenceParent @throws
	 */
	// @ResponseBody
	// @RequestMapping("findAllSignIntegral")
	// public VisitConsequenceParent findAllSignIntegral(
	// HttpServletResponse response,HttpServletRequest request,@RequestBody
	// Map<String,Object>json) {
	// VisitConsequenceParent vc = new VisitConsequenceParentImpl();
	// SignIntegralEntity signIntegralEntity = new SignIntegralEntity();
	// SessionEntity sessionEntity=null;//初始化
	// try {
	// sessionEntity = new SessionEntity(request);//获取用户session
	// } catch (SessionException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// vc.setState(3);
	// return vc;
	// }
	// /**/
	// signIntegralEntity.setUser_basics_id(sessionEntity.getUser_basics_id());
	// /*查询所有签到所有记录*/
	// List<SignIntegralEntity> signIntegralEntities =
	// signIntegralService.findAllSignIntegral(signIntegralEntity);
	//
	// if(signIntegralEntities == null){
	// vc.setMessage("数据查询为空");
	// vc.setState(1);
	//
	// }else{
	// vc.setMessage("查询成功");
	// vc.setState(0);
	// vc.setObject(signIntegralEntities);
	// }
	// return vc;
	// }
	//
	/**
	 * 用户注册
	 *
	 * @param request
	 * @param jsonData微信信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addUserBasic")
	public ResponseData addUserBasic(HttpServletRequest request,
									 @RequestBody Map<String, Object> jsonData) {
		BasicsUser basicsUser = new BasicsUser();
		UserWeixin uw = new UserWeixin();// 用户微信信息
		//VisitUserImpl vui = new VisitUserImpl();
		ResponseData rs = new ResponseData();
		BasicsUser basicsUserData = new BasicsUser();
		Date date = new Date();
		// 基本用户信息
		String userNickname = null;
		try {
			userNickname = jsonData.get("weixin_nickname").toString();// 微信昵称
		} catch (Exception e) {
			userNickname = "";
		}
		String userRegisterAddress = String.valueOf(jsonData
				.get("user_register_address"));// 注册地址
		String userPassword = String.valueOf(jsonData.get("user_password"));// 密码
		String userRegisterData = String.valueOf(jsonData
				.get("user_register_data"));// 注册时间
		// bu1.setUserNickname(userNickname);
		basicsUser.setUser_register_address(userRegisterAddress);
		basicsUser.setUser_password(userPassword);
		if (userRegisterData != null && userRegisterData.equals("")) {
			Long userRegisterData2 = Long.valueOf(userRegisterData);
			basicsUser.setUser_register_data(userRegisterData2);
		} else {
			basicsUser.setUser_register_data(date.getTime());// 如果未传入，默认当前时间
		}
		;

		basicsUser.setUser_grade_id(1);// 用户等级
		// 用户微信信息
		uw.setWeixin_id(jsonData.get("weixin_id").toString());
		try {
			uw.setWeixin_portrait(jsonData.get("weixin_portrait").toString());
		} catch (Exception e) {
			uw.setWeixin_portrait("");
		}

		uw.setWeixin_nickname(userNickname);
		try {
			uw.setWeixin_gender(Integer.parseInt(jsonData.get("weixin_gender")
					.toString()));
		} catch (Exception e) {
			uw.setWeixin_gender(0);
		}
		try {
			uw.setWeixin_follow_choice(Integer.parseInt(jsonData.get(
					"weixin_follow_choice").toString()));
		} catch (Exception e) {
			uw.setWeixin_follow_choice(0);
		}
		Long dbl = 0l;
		try {
			uw.setWeixin_follow_data_yes(Long.valueOf(jsonData.get(
					"weixin_follow_data_yes").toString()));
		} catch (Exception e) {
			uw.setWeixin_follow_data_yes(dbl);
		}
		try {
			uw.setWeixin_follow_data_no(Long.valueOf(jsonData.get(
					"weixin_follow_data_no").toString()));
		} catch (Exception e) {
			uw.setWeixin_follow_data_no(dbl);
		}

		int userid = 0;

		// TODO Auto-generated catch block
		// 返回添加的用户id
		//basicsUserData.setBasicsUser(basicsUser);
		//vui.setBasicsUserData(basicsUserData);

		String recommend_superior_winxin = String.valueOf(jsonData
				.get("recommend_superior_winxin"));// 推荐人微信id
		userid = userService.addUserWeixin(basicsUser, uw,
				recommend_superior_winxin);

		// 多线程执行业务
		Map<String, Object> threadData = new HashMap<String, Object>();
		threadData.put("user_basics_id", userid);
		threadData.put("recommend_superior_winxin", recommend_superior_winxin);
		try {
			//new Thread(new UserThread(threadData), "initializeUserData")
			//		.start();// 初始化用户数据
		} catch (Exception e) {// 初始化用户数据失败
			// TODO: handle exception
			e.printStackTrace();
		}
		//vui.setMessage("注册成功");
		//vui.setState(0);
		//vui.setUserWeixinData(new UserWeixinData(uw));
		rs.setData(uw);
		rs.setMessage("0");
		rs.setErrorCode("200");
		return rs;
	}
	/**
	 * 问卷调查
	 *
	 * @param request
	 * @param jsonData微信信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addQuestionnaire")
	public ResponseData addQuestionnaire(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		SessionEntity se = null;
		int user_basics_id;
		try {
			se = new SessionEntity(request);
			user_basics_id=se.getUser_basics_id();
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserInformationEntity ue=userInformationMapper.selectUserInformationEntityToUserId(user_basics_id);
		String information_compellation = String.valueOf( request.getParameter("information_compellation"));//真实姓名
		int information_sex = Integer.valueOf(String.valueOf( request.getParameter("information_sex")));//性别
		String age_subsection = String.valueOf( request.getParameter("age_subsection"));//年龄段
		String user_job = String.valueOf( request.getParameter("user_job"));//职业
		String information_phone = String.valueOf( request.getParameter("information_phone"));//电话
		int marital_status = Integer.valueOf(String.valueOf( request.getParameter("marital_status")));//婚姻状态
		String know_more = String.valueOf( request.getParameter("know_more"));//了解更多
		ue.setInformation_compellation(information_compellation);
		ue.setInformation_sex(information_sex);
		ue.setAge_subsection(age_subsection);
		ue.setUser_job(user_job);
		ue.setInformation_phone(information_phone);
		ue.setMarital_status(marital_status);
		ue.setKnow_more(know_more);
		int update=userInformationMapper.updateUserInformation(ue);
		if(update>0){
			rs.setData(update);
			rs.setIsSuccess(true);
			rs.setMessage("添加成功!");
		}else{
			rs.setIsSuccess(false);
			rs.setMessage("添加失败!");
		}

		return rs;
	}
	/**
	 * 问卷调查
	 *
	 * @param request
	 * @param jsonData微信信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selectUserInformationEntityToUserId")
	public ResponseData selectUserInformationEntityToUserId(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		SessionEntity se = null;
		int user_basics_id;
		try {
			se = new SessionEntity(request);
			user_basics_id=se.getUser_basics_id();
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserInformationEntity ue=userInformationMapper.selectUserInformationEntityToUserId(user_basics_id);
		rs.setData(ue);
		rs.setIsSuccess(true);
		rs.setMessage("查询成功!");

		return rs;
	}
	/**
	 * 问卷调查
	 *
	 * @param request
	 * @param jsonData微信信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("selectRecommend")
	public ResponseData selectRecommend(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		int recommend_superior = Integer.valueOf(String.valueOf( request.getParameter("recommend_superior")));//性别
		SessionEntity se = null;
		int user_basics_id;
		try {
			se = new SessionEntity(request);
			user_basics_id=se.getUser_basics_id();
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		UserInformationEntity ue=userInformationMapper.selectUserInformationEntityToUserId(recommend_superior);
		rs.setData(ue);
		rs.setIsSuccess(true);
		rs.setMessage("查询成功!");

		return rs;
	}
	/**UserRecommendMapper
	 * 问卷调查
	 *
	 * @param request
	 * @param jsonData微信信息
	 * @return
	 */
	@ResponseBody
	@RequestMapping("updateRecommend")
	public ResponseData updateRecommend(HttpServletResponse response, HttpServletRequest request) {
		ResponseData rs = new ResponseData();
		int recommend_superior = Integer.valueOf(String.valueOf( request.getParameter("recommend_superior")));//性别
		SessionEntity se = null;
		UserRecommend ur=new UserRecommend();
		int user_basics_id;
		try {
			se = new SessionEntity(request);
			user_basics_id=se.getUser_basics_id();
		} catch (SessionException e) {
			e.printStackTrace();
			rs.setIsSuccess(false);
			return rs;
		}
		ur.setUser_basics_id(user_basics_id);
		ur.setRecommend_superior(recommend_superior);
		UserInformationEntity ue=userInformationMapper.selectUserInformationEntityToUserId(recommend_superior);
		if(ue==null){
			rs.setIsSuccess(false);
			rs.setMessage("修改失败!");
		}else{
			int update=userRecommendMapper.updateUserRecommend(ur);
			rs.setData(update);
			rs.setIsSuccess(true);
			rs.setMessage("修改成功!");
		}

		return rs;
	}
}
