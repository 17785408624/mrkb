package com.mrkb.dao.modle.store;

import java.util.ArrayList;
import java.util.List;

public class StoreBasics {//商品信息
	private Integer store_id;//商品ID
	private Double store_price;//商品价格
	private String store_picture;//商品图片
	private String store_intro;//商品简介
	private Integer user_basics_id;//添加人ID
	private String user_nickname;//添加人姓名
	private Long add_date;//添加时间
	private String store_name;//商品名称
	private int store_type;//商品类型（0商城，1定制）
	private String store_service;//定制服务
	private Integer status_state;//商品状态
	private String tutor_name;//导师姓名
	private String class_hour;//课时
	private Integer tutor_num;//导师人数
	private Integer goods_id;//对应货物编号
	private Integer goods_num;//所需货物数量
	private Integer course_type;//课程类型
	private Integer academic_type;//学院类型
	private String store_unit;//单位
	private Double other_price=0.00;//差价
	private Integer user_grade_id;//购买后提升的等级
	private Integer is_letang;//是否为乐唐大学的课程(1是,2不是)
	private Integer is_integralBean;//是否能用快乐豆兑换k课程(1.能，2不能)
	private Integer is_gift;//是否为套餐
	private String store_ids;//套餐包含的课程
	private List<StoreGift> sg;
	private  String gift_user_name;//会员名称
	private  Integer gift_user_basics_id;//会员名称
	private  Long  business_date;//交易时间
	private Integer shelf_state;  //是否下架(1.否，2是)
    private Double profit_money;//利润
    private Integer business_id;//商家编号
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public Double getStore_price() {
		return store_price;
	}
	public void setStore_price(Double store_price) {
		this.store_price = store_price;
	}
	public String getStore_picture() {
		return store_picture;
	}
	public void setStore_picture(String store_picture) {
		this.store_picture = store_picture;
	}
	public String getStore_intro() {
		return store_intro;
	}
	public void setStore_intro(String store_intro) {
		this.store_intro = store_intro;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public int getStore_type() {
		return store_type;
	}
	public void setStore_type(int store_type) {
		this.store_type = store_type;
	}
	public String getStore_service() {
		return store_service;
	}
	public void setStore_service(String store_service) {
		this.store_service = store_service;
	}
	public Integer getStatus_state() {
		return status_state;
	}
	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
	}
	public String getTutor_name() {
		return tutor_name;
	}
	public void setTutor_name(String tutor_name) {
		this.tutor_name = tutor_name;
	}
	public String getClass_hour() {
		return class_hour;
	}
	public void setClass_hour(String class_hour) {
		this.class_hour = class_hour;
	}
	public Integer getTutor_num() {
		return tutor_num;
	}
	public void setTutor_num(Integer tutor_num) {
		this.tutor_num = tutor_num;
	}
	public Integer getGoods_id() {
		return goods_id;  
	}
	public void setGoods_id(Integer goods_id) {
		this.goods_id = goods_id;
	}
	public Integer getGoods_num() {
		return goods_num;
	}
	public void setGoods_num(Integer goods_num) {
		this.goods_num = goods_num;
	}
	public Integer getCourse_type() {
		return course_type;
	}
	public void setCourse_type(Integer course_type) {
		this.course_type = course_type;
	}
	public Integer getAcademic_type() {
		return academic_type;
	}
	public void setAcademic_type(Integer academic_type) {
		this.academic_type = academic_type;
	}
	public String getStore_unit() {
		return store_unit;
	}
	public void setStore_unit(String store_unit) {
		this.store_unit = store_unit;
	}
	public Double getOther_price() {
		return other_price;
	}
	public void setOther_price(Double other_price) {
		this.other_price = other_price;
	}
	public Integer getUser_grade_id() {
		return user_grade_id;
	}
	public void setUser_grade_id(Integer user_grade_id) {
		this.user_grade_id = user_grade_id;
	}
	public Integer getIs_letang() {
		return is_letang;
	}
	public void setIs_letang(Integer is_letang) {
		this.is_letang = is_letang;
	}
	public Integer getIs_integralBean() {
		return is_integralBean;
	}
	public void setIs_integralBean(Integer is_integralBean) {
		this.is_integralBean = is_integralBean;
	}
	public Integer getIs_gift() {
		return is_gift;
	}
	public void setIs_gift(Integer is_gift) {
		this.is_gift = is_gift;
	}
	public String getStore_ids() {
		return store_ids;
	}
	public void setStore_ids(String store_ids) {
		this.store_ids = store_ids;
	}
	public List<StoreGift> getSg() {
		return sg;
	}
	public void setSg(List<StoreGift> sg) {
		this.sg = sg;
	}
	public String getGift_user_name() {
		return gift_user_name;
	}
	public void setGift_user_name(String gift_user_name) {
		this.gift_user_name = gift_user_name;
	}
	public Integer getGift_user_basics_id() {
		return gift_user_basics_id;
	}
	public void setGift_user_basics_id(Integer gift_user_basics_id) {
		this.gift_user_basics_id = gift_user_basics_id;
	}
	public Long getBusiness_date() {
		return business_date;
	}
	public void setBusiness_date(Long business_date) {
		this.business_date = business_date;
	}
	
	public Integer getShelf_state() {
		return shelf_state;
	}
	public void setShelf_state(Integer shelf_state) {
		this.shelf_state = shelf_state;
	}

    public Double getProfit_money() {
        return profit_money;
    }

    public void setProfit_money(Double profit_money) {
        this.profit_money = profit_money;
    }

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    @Override
    public String toString() {
        return "StoreBasics{" +
                "store_id=" + store_id +
                ", store_price=" + store_price +
                ", store_picture='" + store_picture + '\'' +
                ", store_intro='" + store_intro + '\'' +
                ", user_basics_id=" + user_basics_id +
                ", user_nickname='" + user_nickname + '\'' +
                ", add_date=" + add_date +
                ", store_name='" + store_name + '\'' +
                ", store_type=" + store_type +
                ", store_service='" + store_service + '\'' +
                ", status_state=" + status_state +
                ", tutor_name='" + tutor_name + '\'' +
                ", class_hour='" + class_hour + '\'' +
                ", tutor_num=" + tutor_num +
                ", goods_id=" + goods_id +
                ", goods_num=" + goods_num +
                ", course_type=" + course_type +
                ", academic_type=" + academic_type +
                ", store_unit='" + store_unit + '\'' +
                ", other_price=" + other_price +
                ", user_grade_id=" + user_grade_id +
                ", is_letang=" + is_letang +
                ", is_integralBean=" + is_integralBean +
                ", is_gift=" + is_gift +
                ", store_ids='" + store_ids + '\'' +
                ", sg=" + sg +
                ", gift_user_name='" + gift_user_name + '\'' +
                ", gift_user_basics_id=" + gift_user_basics_id +
                ", business_date=" + business_date +
                ", shelf_state=" + shelf_state +
                ", profit_money=" + profit_money +
                ", business_id=" + business_id +
                '}';
    }
}
