package com.mrkb.dao.modle.store;

public class Business {
	private Integer business_id;//商家编号
    private Integer user_basics_id;//用户编号
    private String business_name;//商店名称
    private String business_addr;//商店地址
    private String business_picture;//商店图片
    private String business_info;//商店简介
    private Long add_time;//添加时间
    private Integer status_state;//状态 0正常，1不正常

    public Integer getBusiness_id() {
        return business_id;
    }

    public void setBusiness_id(Integer business_id) {
        this.business_id = business_id;
    }

    public Integer getUser_basics_id() {
        return user_basics_id;
    }

    public void setUser_basics_id(Integer user_basics_id) {
        this.user_basics_id = user_basics_id;
    }

    public String getBusiness_name() {
        return business_name;
    }

    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    public String getBusiness_addr() {
        return business_addr;
    }

    public void setBusiness_addr(String business_addr) {
        this.business_addr = business_addr;
    }

    public String getBusiness_picture() {
        return business_picture;
    }

    public void setBusiness_picture(String business_picture) {
        this.business_picture = business_picture;
    }

    public String getBusiness_info() {
        return business_info;
    }

    public void setBusiness_info(String business_info) {
        this.business_info = business_info;
    }

    public Long getAdd_time() {
        return add_time;
    }

    public void setAdd_time(Long add_time) {
        this.add_time = add_time;
    }

    public Integer getStatus_state() {
        return status_state;
    }

    public void setStatus_state(Integer status_state) {
        this.status_state = status_state;
    }

    @Override
    public String toString() {
        return "Business{" +
                "business_id=" + business_id +
                ", user_basics_id=" + user_basics_id +
                ", business_name='" + business_name + '\'' +
                ", business_addr='" + business_addr + '\'' +
                ", business_picture='" + business_picture + '\'' +
                ", business_info='" + business_info + '\'' +
                ", add_time=" + add_time +
                ", status_state=" + status_state +
                '}';
    }
}
