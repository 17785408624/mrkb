package com.mrkb.dao.modle.user;

public class UserWeixin {//用户微信
	private Integer user_weixin_id;//自增id
	private String weixin_id;//微信id
	private String weixin_portrait;//微信头像
	private String weixin_nickname;//微信昵称
	private Integer weixin_gender;//微信性别
	private Integer weixin_follow_choice;//是否关注
	private Long weixin_follow_data_yes;//关注时间
	private Long weixin_follow_data_no;//取消关注时间
	private Integer user_basics_id;//关联user表自增ID
	private String share_img;//用户分享二维码
	private Long share_img_dated;//用户分享二维码过期日期
	private String information_compellation;//用户真实姓名
	
	private Integer user_grade_id;//用户等级
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
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
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
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	@Override
	public String toString() {
		return "UserWeixin [user_weixin_id=" + user_weixin_id + ", weixin_id="
				+ weixin_id + ", weixin_portrait=" + weixin_portrait
				+ ", weixin_nickname=" + weixin_nickname + ", weixin_gender="
				+ weixin_gender + ", weixin_follow_choice="
				+ weixin_follow_choice + ", weixin_follow_data_yes="
				+ weixin_follow_data_yes + ", weixin_follow_data_no="
				+ weixin_follow_data_no + ", user_basics_id=" + user_basics_id
				+ ", share_img=" + share_img + ", share_img_dated="
				+ share_img_dated + ", information_compellation="
				+ information_compellation + ", user_grade_id=" + user_grade_id
				+ "]";
	}
	

}
