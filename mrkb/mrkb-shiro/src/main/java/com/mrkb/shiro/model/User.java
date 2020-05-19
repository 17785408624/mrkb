/**
 * FileName: User
 * Author:   Administrator
 * Date:     2017/12/2 20:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mrkb.shiro.model;

/**
 * 用户
 * @author Administrator
 * @create 2017/12/2
 * @since 1.0.0
 */
public class User {

	private Integer user_basics_id;//用户自增ID
	private String user_nickname;//用户昵称
	private String user_password;//用户密码
	private Long user_register_data;//用户注册时间
	private String user_register_address;//用户注册地址
	private Integer user_grade_id;//用户等级id
	private String user_account_num;//用户账号
	private Long low_vip_time;//体验会员期限
	private Long vip_time;//会员期限
	private Long health_time;//健康会员
	private Double user_money;//用户余额
	
	//拓展字段（角色编号）
	private Integer role_id;
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
	public Long getLow_vip_time() {
		return low_vip_time;
	}
	public void setLow_vip_time(Long low_vip_time) {
		this.low_vip_time = low_vip_time;
	}
	public Long getVip_time() {
		return vip_time;
	}
	public void setVip_time(Long vip_time) {
		this.vip_time = vip_time;
	}
	public Long getHealth_time() {
		return health_time;
	}
	public void setHealth_time(Long health_time) {
		this.health_time = health_time;
	}
	public Double getUser_money() {
		return user_money;
	}
	public void setUser_money(Double user_money) {
		this.user_money = user_money;
	}
	
	public Integer getRole_id() {
		return role_id;
	}
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	@Override
	public String toString() {
		return "BasicsUser [user_basics_id=" + user_basics_id
				+ ", user_nickname=" + user_nickname + ", user_password="
				+ user_password + ", user_register_data=" + user_register_data
				+ ", user_register_address=" + user_register_address
				+ ", user_grade_id=" + user_grade_id + ", user_account_num="
				+ user_account_num + ", low_vip_time=" + low_vip_time
				+ ", vip_time=" + vip_time + ", health_time=" + health_time
				+ ", user_money=" + user_money + "]";
	}
}