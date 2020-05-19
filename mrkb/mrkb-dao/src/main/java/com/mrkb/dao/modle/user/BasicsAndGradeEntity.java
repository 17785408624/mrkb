package com.mrkb.dao.modle.user;

public class BasicsAndGradeEntity {
	private Integer user_basics_id;//用户自增ID
	private Integer user_grade_id;//用户等级id
	private String grade_name;// 等级名字
	private String grade_describe;// 等级描述
	private String grade_nickname;// 等级昵称
	private String grade_benefit;// 等级受益
	private String upgrade_order;//升级顺序
	private String user_nickname;//用户昵称
	private String user_password;//用户密码
	private Long user_register_data;//用户注册时间
	private String user_register_address;//用户注册地址
	private String grade_introduce;//会员等级介绍
	private String information_compellation;//用户真实姓名
	
	
	private String information_card;//身份证号
	private String weixin_nickname;//微信昵称
	private String information_phone;//用户手机号
	private Integer information_sex;//用户性别
	private Integer co_founder;//用户品牌大使标识
	
	private String identityCard_img1;//身份证照片
	//品牌大使
	private Integer user_resources;//客户归属(1公司资源 2个人资源)
	private Integer co_user_basics_id;//所属品牌大使
	private String information_compellation3;//品牌大使姓名
	//推荐人 
	private Integer user_basics_id2;//推荐人编号
	private String information_compellation2;//推荐人姓名
	private String weixin_nickname2;//推荐人微信昵称
	
	
	public Integer getUser_resources() {
		return user_resources;
	}
	public void setUser_resources(Integer user_resources) {
		this.user_resources = user_resources;
	}
	public String getInformation_compellation3() {
		return information_compellation3;
	}
	public void setInformation_compellation3(String information_compellation3) {
		this.information_compellation3 = information_compellation3;
	}
	public Integer getUser_basics_id2() {
		return user_basics_id2;
	}
	public void setUser_basics_id2(Integer user_basics_id2) {
		this.user_basics_id2 = user_basics_id2;
	}
	public String getInformation_compellation2() {
		return information_compellation2;
	}
	public void setInformation_compellation2(String information_compellation2) {
		this.information_compellation2 = information_compellation2;
	}
	public String getWeixin_nickname2() {
		return weixin_nickname2;
	}
	public void setWeixin_nickname2(String weixin_nickname2) {
		this.weixin_nickname2 = weixin_nickname2;
	}
	public String getInformation_phone() {
		return information_phone;
	}
	public void setInformation_phone(String information_phone) {
		this.information_phone = information_phone;
	}
	public Integer getInformation_sex() {
		return information_sex;
	}
	public void setInformation_sex(Integer information_sex) {
		this.information_sex = information_sex;
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
	public String getGrade_introduce() {
		return grade_introduce;
	}
	public void setGrade_introduce(String grade_introduce) {
		this.grade_introduce = grade_introduce;
	}
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	public String getGrade_describe() {
		return grade_describe;
	}
	public void setGrade_describe(String grade_describe) {
		this.grade_describe = grade_describe;
	}
	public String getGrade_nickname() {
		return grade_nickname;
	}
	public void setGrade_nickname(String grade_nickname) {
		this.grade_nickname = grade_nickname;
	}
	public String getGrade_benefit() {
		return grade_benefit;
	}
	public void setGrade_benefit(String grade_benefit) {
		this.grade_benefit = grade_benefit;
	}
	public String getUpgrade_order() {
		return upgrade_order;
	}
	public void setUpgrade_order(String upgrade_order) {
		this.upgrade_order = upgrade_order;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public Long getUser_register_data() {
		return user_register_data;
	}
	public void setUser_register_data(Long user_register_data) {
		this.user_register_data = user_register_data;
	}
	public String getUser_register_address() {
		return user_register_address;
	}
	public void setUser_register_address(String user_register_address) {
		this.user_register_address = user_register_address;
	}
	
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	
	public String getWeixin_nickname() {
		return weixin_nickname;
	}
	public void setWeixin_nickname(String weixin_nickname) {
		this.weixin_nickname = weixin_nickname;
	}
	public String getInformation_card() {
		return information_card;
	}
	public void setInformation_card(String information_card) {
		this.information_card = information_card;
	}
	public BasicsAndGradeEntity(String grade_name, Integer user_grade_id,
			String grade_describe, String grade_nickname, String grade_benefit,
			String upgrade_order, Integer user_basics_id, String user_nickname,
			String user_password, Long user_register_data,
			String user_register_address,String grade_introduce,String information_compellation) {
		super();
		this.grade_name = grade_name;
		this.user_grade_id = user_grade_id;
		this.grade_describe = grade_describe;
		this.grade_nickname = grade_nickname;
		this.grade_benefit = grade_benefit;
		this.upgrade_order = upgrade_order;
		this.user_basics_id = user_basics_id;
		this.user_nickname = user_nickname;
		this.user_password = user_password;
		this.user_register_data = user_register_data;
		this.user_register_address = user_register_address;
		this.grade_introduce = grade_introduce;
		this.information_compellation =information_compellation;
	}
	public BasicsAndGradeEntity() {
		
	}
	
	
}
