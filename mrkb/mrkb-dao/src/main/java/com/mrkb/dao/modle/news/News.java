package com.mrkb.dao.modle.news;

public class News {
	private Integer news_id;//知识编号
	private Integer news_type;//知识类型
	private String news_title;//知识标题
	private Long update_date;//修改时间
	private Integer read_num;//阅读量
	private Integer thumbs_up;//点赞量
	private Long add_date;//添加时间
	private String detail_content;//详细内容
	private String news_picture;//知识图片
	private Integer status_state;//知识状态
	private Double fund_money=0.00;//基金的钱
	private String news_mp3;//音乐链接
	private String view_road;//视频路径
	public Integer getNews_id() {
		return news_id;
	}
	public void setNews_id(Integer news_id) {
		this.news_id = news_id;
	}
	public Integer getNews_type() {
		return news_type;
	}
	public void setNews_type(Integer news_type) {
		this.news_type = news_type;
	}
	public String getNews_title() {
		return news_title;
	}
	public void setNews_title(String news_title) {
		this.news_title = news_title;
	}
	public Long getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Long update_date) {
		this.update_date = update_date;
	}
	public Integer getRead_num() {
		return read_num;
	}
	public void setRead_num(Integer read_num) {
		this.read_num = read_num;
	}
	public Integer getThumbs_up() {
		return thumbs_up;
	}
	public void setThumbs_up(Integer thumbs_up) {
		this.thumbs_up = thumbs_up;
	}
	public Long getAdd_date() {
		return add_date;
	}
	public void setAdd_date(Long add_date) {
		this.add_date = add_date;
	}
	public String getDetail_content() {
		return detail_content;
	}
	public void setDetail_content(String detail_content) {
		this.detail_content = detail_content;
	}
	public String getNews_picture() {
		return news_picture;
	}
	public void setNews_picture(String news_picture) {
		this.news_picture = news_picture;
	}
	public Integer getStatus_state() {
		return status_state;
	}
	public void setStatus_state(Integer status_state) {
		this.status_state = status_state;
	}
	public Double getFund_money() {
		return fund_money;
	}
	public void setFund_money(Double fund_money) {
		this.fund_money = fund_money;
	}
	public String getNews_mp3() {
		return news_mp3;
	}
	public void setNews_mp3(String news_mp3) {
		this.news_mp3 = news_mp3;
	}
	public String getView_road() {
		return view_road;
	}
	public void setView_road(String view_road) {
		this.view_road = view_road;
	}
	@Override
	public String toString() {
		return "News [news_id=" + news_id + ", news_type=" + news_type + ", news_title=" + news_title + ", update_date="
				+ update_date + ", read_num=" + read_num + ", thumbs_up=" + thumbs_up + ", add_date=" + add_date
				+ ", detail_content=" + detail_content + ", news_picture=" + news_picture + ", status_state="
				+ status_state + ", fund_money=" + fund_money + ", news_mp3=" + news_mp3 + ", view_road=" + view_road
				+ "]";
	}
	
}
