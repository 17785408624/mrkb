package com.mrkb.dao.modle.integr;
/**
 * 
 *@param
 *@return
 * @author liangyi
 * @description 签到积分实体类
 */
public class SignIntegralEntity {
	
	private Integer sign_id;//签到id
	private Integer user_basics_id;//用户id
	private Integer sign_num;//签到积分
	private Long sign_date;//签到日期
	public Integer getSign_id() {
		return sign_id;
	}
	public void setSign_id(Integer sign_id) {
		this.sign_id = sign_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getSign_num() {
		return sign_num;
	}
	public void setSign_num(Integer sign_num) {
		this.sign_num = sign_num;
	}
	public Long getSign_date() {
		return sign_date;
	}
	public void setSign_date(Long sign_date) {
		this.sign_date = sign_date;
	}
	@Override
	public String toString() {
		return "SignIntegralEntity [sign_id=" + sign_id + ", user_basics_id="
				+ user_basics_id + ", sign_num=" + sign_num + ", sign_date="
				+ sign_date + "]";
	}
	
	
}
