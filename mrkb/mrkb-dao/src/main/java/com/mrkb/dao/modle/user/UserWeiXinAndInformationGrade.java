package com.mrkb.dao.modle.user;
/**
 * 用户、微信、实名认证及会员等级实体类
 * @author Administrator
 *
 */
public class UserWeiXinAndInformationGrade {

	private String weixin_id;//微信id
	private String weixin_portrait;//微信头像
	private String weixin_nickname;//微信昵称
	private Integer weixin_gender;//微信性别
	private Integer weixin_follow_choice;//是否关注
	private Long weixin_follow_data_yes;//关注时间
	private Long weixin_follow_data_no;//取消关注时间
	private Integer user_basics_id;//关联user表自增ID
	private String user_nickname;//用户昵称
	private Long user_register_data;//用户注册时间
	private String user_register_address;//用户注册地址
	private String information_phone;//用户手机号
	private String information_qq;//用户qq账号
	private String information_Email;//用户电子邮箱
	private String information_compellation;//用户真实姓名
	private String information_card;//用户身份证号
	private Long card_end;//身份证到期时间
	private Integer information_sex;//用户性别
	private String nick_name;//用户昵称
	private String live_address;//用户现居住地
	private String registered_address;//用户户口所在地
	private String information_weixin;//用户微信号
	private String card_picture;//用户身份证图片
	private Integer information_age;//年龄
	private String grade_name;// 等级名字
	private String grade_nickname;// 等级昵称
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
	public Long getCard_end() {
		return card_end;
	}
	public void setCard_end(Long card_end) {
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
	public String getGrade_name() {
		return grade_name;
	}
	public void setGrade_name(String grade_name) {
		this.grade_name = grade_name;
	}
	public String getGrade_nickname() {
		return grade_nickname;
	}
	public void setGrade_nickname(String grade_nickname) {
		this.grade_nickname = grade_nickname;
	}
	
	public UserWeiXinAndInformationGrade(){
		
		
	}
	public UserWeiXinAndInformationGrade(String weixin_id,
			String weixin_portrait, String weixin_nickname,
			Integer weixin_gender, Integer weixin_follow_choice,
			Long weixin_follow_data_yes, Long weixin_follow_data_no,
			Integer user_basics_id, String user_nickname,
			Long user_register_data, String user_register_address,
			String information_phone, String information_qq,
			String information_Email, String information_compellation,
			String information_card, Long card_end, Integer information_sex,
			String nick_name, String live_address, String registered_address,
			String information_weixin, String card_picture,
			Integer information_age, String grade_name, String grade_nickname) {
		super();
		this.weixin_id = weixin_id;
		this.weixin_portrait = weixin_portrait;
		this.weixin_nickname = weixin_nickname;
		this.weixin_gender = weixin_gender;
		this.weixin_follow_choice = weixin_follow_choice;
		this.weixin_follow_data_yes = weixin_follow_data_yes;
		this.weixin_follow_data_no = weixin_follow_data_no;
		this.user_basics_id = user_basics_id;
		this.user_nickname = user_nickname;
		this.user_register_data = user_register_data;
		this.user_register_address = user_register_address;
		this.information_phone = information_phone;
		this.information_qq = information_qq;
		this.information_Email = information_Email;
		this.information_compellation = information_compellation;
		this.information_card = information_card;
		this.card_end = card_end;
		this.information_sex = information_sex;
		this.nick_name = nick_name;
		this.live_address = live_address;
		this.registered_address = registered_address;
		this.information_weixin = information_weixin;
		this.card_picture = card_picture;
		this.information_age = information_age;
		this.grade_name = grade_name;
		this.grade_nickname = grade_nickname;
	}
	
	
}
