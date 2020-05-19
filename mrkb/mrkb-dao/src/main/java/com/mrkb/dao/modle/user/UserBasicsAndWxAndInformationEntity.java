/**
 * FileName:         UserBasicsAndWxAndInformationEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-28     下午2:52:47
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-28     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.user;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class UserBasicsAndWxAndInformationEntity {//用户基本信息和微信信息与用户详细信息封装实体类
	private Integer user_basics_id;//用户自增ID
	private String user_nickname;//用户昵称
	private String user_password;//用户密码
	private Long user_register_data;//用户注册时间
	private String user_register_address;//用户注册地址
	private Integer user_grade_id;//用户等级id
	private String user_account_num;//用户账号
	private Integer user_weixin_id;//自增id
	private String weixin_id;//微信id
	private String weixin_portrait;//微信头像
	private String weixin_nickname;//微信昵称
	private Integer weixin_gender;//微信性别
	private Integer weixin_follow_choice;//是否关注
	private Long weixin_follow_data_yes;//关注时间
	private Long weixin_follow_data_no;//取消关注时间
	private String share_img;//用户分享二维码
	private Long share_img_dated;//用户分享二维码过期日期
	private Integer user_information_id;//数据主键
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
	private Integer co_user_basics_id;//所属联合创办人编号
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
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	public String getUser_account_num() {
		return user_account_num;
	}
	public void setUser_account_num(String user_account_num) {
		this.user_account_num = user_account_num;
	}
	public Integer getUser_weixin_id() {
		return user_weixin_id;
	}
	public void setUser_weixin_id(Integer user_weixin_id) {
		this.user_weixin_id = user_weixin_id;
	}
	public String getWeixin_id() {
		return weixin_id;
	}
	public void setWeixin_id(String weixin_id) {
		this.weixin_id = weixin_id;
	}
	public String getWeixin_portrait() {
		return weixin_portrait;
	}
	public void setWeixin_portrait(String weixin_portrait) {
		this.weixin_portrait = weixin_portrait;
	}
	public String getWeixin_nickname() {
		return weixin_nickname;
	}
	public void setWeixin_nickname(String weixin_nickname) {
		this.weixin_nickname = weixin_nickname;
	}
	public Integer getWeixin_gender() {
		return weixin_gender;
	}
	public void setWeixin_gender(Integer weixin_gender) {
		this.weixin_gender = weixin_gender;
	}
	public Integer getWeixin_follow_choice() {
		return weixin_follow_choice;
	}
	public void setWeixin_follow_choice(Integer weixin_follow_choice) {
		this.weixin_follow_choice = weixin_follow_choice;
	}
	public Long getWeixin_follow_data_yes() {
		return weixin_follow_data_yes;
	}
	public void setWeixin_follow_data_yes(Long weixin_follow_data_yes) {
		this.weixin_follow_data_yes = weixin_follow_data_yes;
	}
	public Long getWeixin_follow_data_no() {
		return weixin_follow_data_no;
	}
	public void setWeixin_follow_data_no(Long weixin_follow_data_no) {
		this.weixin_follow_data_no = weixin_follow_data_no;
	}
	public String getShare_img() {
		return share_img;
	}
	public void setShare_img(String share_img) {
		this.share_img = share_img;
	}
	public Long getShare_img_dated() {
		return share_img_dated;
	}
	public void setShare_img_dated(Long share_img_dated) {
		this.share_img_dated = share_img_dated;
	}
	public Integer getUser_information_id() {
		return user_information_id;
	}
	public void setUser_information_id(Integer user_information_id) {
		this.user_information_id = user_information_id;
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
	@Override
	public String toString() {
		return "UserBasicsAndWxAndInformationEntity [user_basics_id="
				+ user_basics_id + ", user_nickname=" + user_nickname
				+ ", user_password=" + user_password + ", user_register_data="
				+ user_register_data + ", user_register_address="
				+ user_register_address + ", user_grade_id=" + user_grade_id
				+ ", user_account_num=" + user_account_num
				+ ", user_weixin_id=" + user_weixin_id + ", weixin_id="
				+ weixin_id + ", weixin_portrait=" + weixin_portrait
				+ ", weixin_nickname=" + weixin_nickname + ", weixin_gender="
				+ weixin_gender + ", weixin_follow_choice="
				+ weixin_follow_choice + ", weixin_follow_data_yes="
				+ weixin_follow_data_yes + ", weixin_follow_data_no="
				+ weixin_follow_data_no + ", share_img=" + share_img
				+ ", share_img_dated=" + share_img_dated
				+ ", user_information_id=" + user_information_id
				+ ", information_phone=" + information_phone
				+ ", information_qq=" + information_qq + ", information_Email="
				+ information_Email + ", information_compellation="
				+ information_compellation + ", information_card="
				+ information_card + ", company_id=" + company_id
				+ ", card_end=" + card_end + ", information_sex="
				+ information_sex + ", nick_name=" + nick_name
				+ ", live_address=" + live_address + ", registered_address="
				+ registered_address + ", information_weixin="
				+ information_weixin + ", card_picture=" + card_picture
				+ ", information_age=" + information_age + ", co_founder="
				+ co_founder + ", co_user_basics_id=" + co_user_basics_id + "]";
	}
	

}
