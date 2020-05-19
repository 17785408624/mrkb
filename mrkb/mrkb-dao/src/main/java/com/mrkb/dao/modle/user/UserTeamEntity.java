/**
 * FileName:         userTeam.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-4-18     下午4:58:27
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-4-18     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.user;

import com.mrkb.dao.modle.account.IntegralAccount;

/**
 *@param
 *@return
 * @author moerka-1
 *
 */
public class UserTeamEntity {
	private Integer user_basics_id;//用户id
	private Integer recommend_superior;//推荐人用户id
	private String user_nickname;//用户昵称
	private String weixin_portrait;//微信头像
	private String superior_user_nickname;//推荐人用户昵称
	private String weixin_nickname;//用户微信昵称
	private String superior_weixin_nickname;//推荐人微信昵称
	private Integer order_id;//订单id
	private Long order_add_date;//订单添加时间
	private Integer order_status;//订单状态
	private Long order_edit_date;//订单修改时间
	private Integer add_user_basics_id;//添加订单的用户id
	private Integer store_id;//商品id
	private Integer store_amount;//商品数量
	private String order_addr;//订单地址
	private String store_picture;//商品图片
	private Double all_price;//订单总价
	private Integer order_type;//订单类型
	private Integer user_grade_id;//用户等级
	private Integer integrals_no_activce;//用户积分
	private Integer integral_no_activce;//未激活快乐豆
	private Integer integral_basics;//已激活快乐豆
	private String information_compellation;//用户真实姓名
	private String information_phone;//用户联系方式
	private int duty_num;//未当班数量
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getRecommend_superior() {
		return recommend_superior;
	}
	public void setRecommend_superior(Integer recommend_superior) {
		this.recommend_superior = recommend_superior;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public String getSuperior_user_nickname() {
		return superior_user_nickname;
	}
	public void setSuperior_user_nickname(String superior_user_nickname) {
		this.superior_user_nickname = superior_user_nickname;
	}
	public String getWeixin_nickname() {
		return weixin_nickname;
	}
	public void setWeixin_nickname(String weixin_nickname) {
		this.weixin_nickname = weixin_nickname;
	}
	public String getSuperior_weixin_nickname() {
		return superior_weixin_nickname;
	}
	public void setSuperior_weixin_nickname(String superior_weixin_nickname) {
		this.superior_weixin_nickname = superior_weixin_nickname;
	}
	public Integer getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}
	public Long getOrder_add_date() {
		return order_add_date;
	}
	public void setOrder_add_date(Long order_add_date) {
		this.order_add_date = order_add_date;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public Long getOrder_edit_date() {
		return order_edit_date;
	}
	public void setOrder_edit_date(Long order_edit_date) {
		this.order_edit_date = order_edit_date;
	}
	public Integer getAdd_user_basics_id() {
		return add_user_basics_id;
	}
	public void setAdd_user_basics_id(Integer add_user_basics_id) {
		this.add_user_basics_id = add_user_basics_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public Integer getStore_amount() {
		return store_amount;
	}
	public void setStore_amount(Integer store_amount) {
		this.store_amount = store_amount;
	}
	public String getOrder_addr() {
		return order_addr;
	}
	public void setOrder_addr(String order_addr) {
		this.order_addr = order_addr;
	}
	public String getStore_picture() {
		return store_picture;
	}
	public void setStore_picture(String store_picture) {
		this.store_picture = store_picture;
	}
	public Double getAll_price() {
		return all_price;
	}
	public void setAll_price(Double all_price) {
		this.all_price = all_price;
	}
	public Integer getOrder_type() {
		return order_type;
	}
	public void setOrder_type(Integer order_type) {
		this.order_type = order_type;
	}
	public String getWeixin_portrait() {
		return weixin_portrait;
	}
	public void setWeixin_portrait(String weixin_portrait) {
		this.weixin_portrait = weixin_portrait;
	}
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	
	public Integer getIntegrals_no_activce() {
		return integrals_no_activce;
	}
	public void setIntegrals_no_activce(Integer integrals_no_activce) {
		this.integrals_no_activce = integrals_no_activce;
	}
	public Integer getIntegral_no_activce() {
		return integral_no_activce;
	}
	public void setIntegral_no_activce(Integer integral_no_activce) {
		this.integral_no_activce = integral_no_activce;
	}
	public Integer getIntegral_basics() {
		return integral_basics;
	}
	public void setIntegral_basics(Integer integral_basics) {
		this.integral_basics = integral_basics;
	}
	
	public String getInformation_compellation() {
		return information_compellation;
	}
	public void setInformation_compellation(String information_compellation) {
		this.information_compellation = information_compellation;
	}
	public String getInformation_phone() {
		return information_phone;
	}
	public void setInformation_phone(String information_phone) {
		this.information_phone = information_phone;
	}

	public int getDuty_num() {
		return duty_num;
	}

	public void setDuty_num(int duty_num) {
		this.duty_num = duty_num;
	}

	@Override
	public String toString() {
		return "UserTeamEntity [user_basics_id=" + user_basics_id + ", recommend_superior=" + recommend_superior
				+ ", user_nickname=" + user_nickname + ", weixin_portrait=" + weixin_portrait
				+ ", superior_user_nickname=" + superior_user_nickname + ", weixin_nickname=" + weixin_nickname
				+ ", superior_weixin_nickname=" + superior_weixin_nickname + ", order_id=" + order_id
				+ ", order_add_date=" + order_add_date + ", order_status=" + order_status + ", order_edit_date="
				+ order_edit_date + ", add_user_basics_id=" + add_user_basics_id + ", store_id=" + store_id
				+ ", store_amount=" + store_amount + ", order_addr=" + order_addr + ", store_picture=" + store_picture
				+ ", all_price=" + all_price + ", order_type=" + order_type + ", user_grade_id=" + user_grade_id
				+ ", integrals_no_activce=" + integrals_no_activce + ", integral_no_activce=" + integral_no_activce
				+ ", integral_basics=" + integral_basics + ", information_compellation=" + information_compellation
				+ ", information_phone=" + information_phone + "]";
	}
	
	

}
