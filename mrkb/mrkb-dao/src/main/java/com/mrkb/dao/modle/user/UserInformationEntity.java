/**
 * FileName:         UserInformationEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-4     上午9:38:10
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-4     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.user;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class UserInformationEntity {
	private Integer user_information_id;//数据主键
	private Integer user_basics_id;//用户id
	private String information_phone;//用户手机号
	private String information_qq;//用户qq账号
	private String information_Email;//用户电子邮箱
	private String information_compellation;//用户真实姓名
	private String information_card;//用户身份证号
	private Integer company_id;//公司id
	private String card_end;//身份证到期时间
	private Integer information_sex;//用户性别
	private String nick_name;//用户昵称
	private String live_address;//用户现居住地
	private String registered_address;//用户户口所在地
	private String information_weixin;//用户微信号
	private String card_picture;//用户身份证图片
	private Integer information_age;//年龄
	private Integer co_founder;//创办人标识，0：总公司会员，1：分公司会员，2：领衔创办人，3：联合创办人
	private Integer co_user_basics_id=0;//所属联合创办人编号
	private String  identityCard_img1 ;//身份证正面照图片路径信息
	private String  identityCard_img2 ;//身份证反面照图片路径信息
	private Integer old_user_basics_id;//推荐人
	private Integer conver_num=0;//历史卡巴积分
	//user_basics表中数据
	private Integer user_grade_id;//会员等级
	private Long low_vip_time;//体验会员
	private Long health_time;//A系统会员
	private Long vip_time;//B系统会员
	private Double user_money;//钱包
	private String user_account_num;//账号
	private String user_password;//密码
	private Integer is_employee; //是否为员工(1.员工,2不是员工)
	private Integer advisor_user_basics_id;//乐唐顾问id
	private Integer seniorManager_user_basics_id;//高级经理id
	private Integer user_resources;//客户归属(1公司资源 2个人资源)
	private String age_subsection;//年龄分段
	private String user_job;//职业
	private Integer marital_status;//婚姻状况(1已婚, 2未婚)
	private String know_more;//了解更多
	
	private String consult_picture;//顾问图片
	private String consult_view;//顾问视频
	
	//20191211新加成员变量
	 private String recommend_name;//推荐人姓名
	 private String employees;//所属员工姓名
	 private String store_name;//课程名称
	 private Integer order_id;//订单id
	 private  long order_date;//缴费时间
	 private long  duty_date;//当班时间
	 private Integer if_duty;//是否当班
	 private Double all_price;//订单价格
	 private long begin_time;//开始时间
	 private long end_time;//结束时间
	 private Integer source_type;
	 private long add_date;//添加日期
	private String weixin_portrait;//微信头像
	public Integer getUser_resources() {
		return user_resources;
	}
	public void setUser_resources(Integer user_resources) {
		this.user_resources = user_resources;
	}
	public Integer getUser_information_id() {
		return user_information_id;
	}
	public void setUser_information_id(Integer user_information_id) {
		this.user_information_id = user_information_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getInformation_phone() {
		return information_phone;
	}
	public void setInformation_phone(String information_phone) {
		this.information_phone = information_phone;
	}
	public String getInformation_qq() {
		return information_qq;
	}
	public void setInformation_qq(String information_qq) {
		this.information_qq = information_qq;
	}
	public String getInformation_Email() {
		return information_Email;
	}
	public void setInformation_Email(String information_Email) {
		this.information_Email = information_Email;
	}
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public String getInformation_card() {
		return information_card;
	}
	public void setInformation_card(String information_card) {
		this.information_card = information_card;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public String getCard_end() {
		return card_end;
	}
	public void setCard_end(String card_end) {
		this.card_end = card_end;
	}
	public Integer getInformation_sex() {
		return information_sex;
	}
	public void setInformation_sex(Integer information_sex) {
		this.information_sex = information_sex;
	}
	public String getNick_name() {
		return nick_name;
	}
	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}
	public String getLive_address() {
		return live_address;
	}
	public void setLive_address(String live_address) {
		this.live_address = live_address;
	}
	public String getRegistered_address() {
		return registered_address;
	}
	public void setRegistered_address(String registered_address) {
		this.registered_address = registered_address;
	}
	public String getInformation_weixin() {
		return information_weixin;
	}
	public void setInformation_weixin(String information_weixin) {
		this.information_weixin = information_weixin;
	}
	public String getCard_picture() {
		return card_picture;
	}
	public void setCard_picture(String card_picture) {
		this.card_picture = card_picture;
	}
	public Integer getInformation_age() {
		return information_age;
	}
	public void setInformation_age(Integer information_age) {
		this.information_age = information_age;
	}
	public Integer getCo_founder() {
		return co_founder;
	}
	public void setCo_founder(Integer co_founder) {
		this.co_founder = co_founder;
	}
	public Integer getCo_user_basics_id() {
		return co_user_basics_id;
	}
	public void setCo_user_basics_id(Integer co_user_basics_id) {
		this.co_user_basics_id = co_user_basics_id;
	}
	
	public String getIdentityCard_img1() {
		return identityCard_img1;
	}
	public void setIdentityCard_img1(String identityCard_img1) {
		this.identityCard_img1 = identityCard_img1;
	}
	public String getIdentityCard_img2() {
		return identityCard_img2;
	}
	public void setIdentityCard_img2(String identityCard_img2) {
		this.identityCard_img2 = identityCard_img2;
	}
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	public Long getLow_vip_time() {
		return low_vip_time;
	}
	public void setLow_vip_time(Long low_vip_time) {
		this.low_vip_time = low_vip_time;
	}
	public Long getHealth_time() {
		return health_time;
	}
	public void setHealth_time(Long health_time) {
		this.health_time = health_time;
	}
	public Long getVip_time() {
		return vip_time;
	}
	public void setVip_time(Long vip_time) {
		this.vip_time = vip_time;
	}
	public Double getUser_money() {
		return user_money;
	}
	public void setUser_money(Double user_money) {
		this.user_money = user_money;
	}
	public Integer getOld_user_basics_id() {
		return old_user_basics_id;
	}
	public void setOld_user_basics_id(Integer old_user_basics_id) {
		this.old_user_basics_id = old_user_basics_id;
	}
	public String getUser_account_num() {
		return user_account_num;
	}
	public void setUser_account_num(String user_account_num) {
		this.user_account_num = user_account_num;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	
	public Integer getIs_employee() {
		return is_employee;
	}
	public void setIs_employee(Integer is_employee) {
		this.is_employee = is_employee;
	}
	
	
	public Integer getAdvisor_user_basics_id() {
		return advisor_user_basics_id;
	}
	public void setAdvisor_user_basics_id(Integer advisor_user_basics_id) {
		this.advisor_user_basics_id = advisor_user_basics_id;
	}
	public Integer getSeniorManager_user_basics_id() {
		return seniorManager_user_basics_id;
	}
	public void setSeniorManager_user_basics_id(Integer seniorManager_user_basics_id) {
		this.seniorManager_user_basics_id = seniorManager_user_basics_id;
	}
	public Integer getConver_num() {
		return conver_num;
	}
	public void setConver_num(Integer conver_num) {
		this.conver_num = conver_num;
	}
	public String getConsult_picture() {
		return consult_picture;
	}
	public void setConsult_picture(String consult_picture) {
		this.consult_picture = consult_picture;
	}
	public String getConsult_view() {
		return consult_view;
	}
	public void setConsult_view(String consult_view) {
		this.consult_view = consult_view;
	}
	public String getRecommend_name() {
		return recommend_name;
	}
	public void setRecommend_name(String recommend_name) {
		this.recommend_name = recommend_name;
	}
	public String getEmployees() {
		return employees;
	}
	public void setEmployees(String employees) {
		this.employees = employees;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public long getOrder_date() {
		return order_date;
	}
	public void setOrder_date(long order_date) {
		this.order_date = order_date;
	}
	public long getDuty_date() {
		return duty_date;
	}
	public void setDuty_date(long duty_date) {
		this.duty_date = duty_date;
	}
	public Integer getIf_duty() {
		return if_duty;
	}
	public void setIf_duty(Integer if_duty) {
		this.if_duty = if_duty;
	}
	
	public Double getAll_price() {
		return all_price;
	}
	public void setAll_price(Double all_price) {
		this.all_price = all_price;
	}
	public String getAge_subsection() {
		return age_subsection;
	}
	public void setAge_subsection(String age_subsection) {
		this.age_subsection = age_subsection;
	}
	public String getUser_job() {
		return user_job;
	}
	public void setUser_job(String user_job) {
		this.user_job = user_job;
	}
	public Integer getMarital_status() {
		return marital_status;
	}
	public void setMarital_status(Integer marital_status) {
		this.marital_status = marital_status;
	}
	public String getKnow_more() {
		return know_more;
	}
	public void setKnow_more(String know_more) {
		this.know_more = know_more;
	}
	public long getBegin_time() {
		return begin_time;
	}
	public void setBegin_time(long begin_time) {
		this.begin_time = begin_time;
	}
	public long getEnd_time() {
		return end_time;
	}
	public void setEnd_time(long end_time) {
		this.end_time = end_time;
	}
	public Integer getSource_type() {
		return source_type;
	}
	public void setSource_type(Integer source_type) {
		this.source_type = source_type;
	}

	public String getWeixin_portrait() {
		return weixin_portrait;
	}

	public void setWeixin_portrait(String weixin_portrait) {
		this.weixin_portrait = weixin_portrait;
	}

	public long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(long add_date) {
		this.add_date = add_date;
	}
	@Override
	public String toString() {
		return "UserInformationEntity [user_information_id=" + user_information_id + ", user_basics_id="
				+ user_basics_id + ", information_phone=" + information_phone + ", information_qq=" + information_qq
				+ ", information_Email=" + information_Email + ", information_compellation=" + information_compellation
				+ ", information_card=" + information_card + ", company_id=" + company_id + ", card_end=" + card_end
				+ ", information_sex=" + information_sex + ", nick_name=" + nick_name + ", live_address=" + live_address
				+ ", registered_address=" + registered_address + ", information_weixin=" + information_weixin
				+ ", card_picture=" + card_picture + ", information_age=" + information_age + ", co_founder="
				+ co_founder + ", co_user_basics_id=" + co_user_basics_id + ", identityCard_img1=" + identityCard_img1
				+ ", identityCard_img2=" + identityCard_img2 + ", old_user_basics_id=" + old_user_basics_id
				+ ", conver_num=" + conver_num + ", user_grade_id=" + user_grade_id + ", low_vip_time=" + low_vip_time
				+ ", health_time=" + health_time + ", vip_time=" + vip_time + ", user_money=" + user_money
				+ ", user_account_num=" + user_account_num + ", user_password=" + user_password + ", is_employee="
				+ is_employee + ", advisor_user_basics_id=" + advisor_user_basics_id + ", seniorManager_user_basics_id="
				+ seniorManager_user_basics_id + ", user_resources=" + user_resources + ", age_subsection="
				+ age_subsection + ", user_job=" + user_job + ", marital_status=" + marital_status + ", know_more="
				+ know_more + ", consult_picture=" + consult_picture + ", consult_view=" + consult_view
				+ ", recommend_name=" + recommend_name + ", employees=" + employees + ", store_name=" + store_name
				+ ", order_id=" + order_id + ", order_date=" + order_date + ", duty_date=" + duty_date + ", if_duty="
				+ if_duty + ", all_price=" + all_price + ", begin_time=" + begin_time + ", end_time=" + end_time
				+ ", source_type=" + source_type + ", add_date=" + add_date + "]";
	}

}
