package com.mrkb.dao.modle.user;

public class UserMessage {
	private Integer message_id;//消息编号
	private String tb_name;//对应表名
	private Integer tb_id;//对应数据所在表的ID
	private Integer user_basics_id;//用户编号
	private Integer message_type;//消息类型
	private String message_content;//消息内容
	private Long add_date;//添加时间
	private Long read_date;//阅读时间
	private Integer if_read;//0.未读,1.已读
	public Integer getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}
	public Integer getUser_basics_id() {
		return user_basics_id;
	}
	public void setUser_basics_id(Integer user_basics_id) {
		this.user_basics_id = user_basics_id;
	}
	public Integer getMessage_type() {
		return message_type;
	}
	public void setMessage_type(Integer message_type) {
		this.message_type = message_type;
	}
	public String getMessage_content() {
		return message_content;
	}
	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public Long getRead_date() {
		return read_date;
	}
	public void setRead_date(Long read_date) {
		this.read_date = read_date;
	}
	public Integer getIf_read() {
		return if_read;
	}
	public void setIf_read(Integer if_read) {
		this.if_read = if_read;
	}
	public String getTb_name() {
		return tb_name;
	}
	public void setTb_name(String tb_name) {
		this.tb_name = tb_name;
	}
	public Integer getTb_id() {
		return tb_id;
	}
	public void setTb_id(Integer tb_id) {
		this.tb_id = tb_id;
	}
	@Override
	public String toString() {
		return "UserMessage [message_id=" + message_id + ", tb_name=" + tb_name
				+ ", tb_id=" + tb_id + ", user_basics_id=" + user_basics_id
				+ ", message_type=" + message_type + ", message_content="
				+ message_content + ", add_date=" + add_date + ", read_date="
				+ read_date + ", if_read=" + if_read + "]";
	}
	
}
