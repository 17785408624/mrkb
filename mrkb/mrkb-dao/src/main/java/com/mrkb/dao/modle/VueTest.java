package com.mrkb.dao.modle;

public class VueTest {
	
	private Integer id;
	//姓名
	private String name;
	//地址
	private String addrr;
	//工作年限
	private Integer work_date;
	//状态
	private Integer state;
	//专业
	private String major;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddrr() {
		return addrr;
	}
	public void setAddrr(String addrr) {
		this.addrr = addrr;
	}
	public Integer getWork_date() {
		return work_date;
	}
	public void setWork_date(Integer work_date) {
		this.work_date = work_date;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return "VueTest [id=" + id + ", name=" + name + ", addrr=" + addrr + ", work_date=" + work_date + ", state="
				+ state + ", major=" + major + "]";
	}
	

}
