/**
 * FileName:         ArticleEntity.java
 * @Description:     TODO
 * @author:            crane-yuan
 * @version            V1.0
 * Createdate:      2018-5-18     下午1:57:12
 * Copyright:        Copyright(C) 2016-2017
 * Company           CY.
 * All rights Reserved, Designed By crane-yuan

 * Modification  History:
 * Date         Author        Version        Discription
 * ---------------------------------------------------------------------------
 * 2018-5-18     crane-yuan       1.0             1.0

 * Why & What is modified:

 */
package com.mrkb.dao.modle.article;


/**
 *@param
 *@return
 * @author liangyi
 *
 */
public class ArticleEntity {
  private	Integer article_id;//主键id
  private Integer article_type;//类型
  private Integer template_type;//模板类型
  private String title;// 标题
  private String author;//作者
  private String content_introduction;//内容介绍
  private String content;//内容
  private Long writing_time;//写入时间
  private Long modification_time;//修改时间
  private Integer browse_volume;//浏览量
  private Integer status;//审核状态
  private String remarks;// 备注
  private String	pictures_url;//图片路径
  private String audio_url;// 视频路径
public Integer getArticle_id() {
	return article_id;
}
public void setArticle_id(Integer article_id) {
	this.article_id = article_id;
}
public Integer getArticle_type() {
	return article_type;
}
public void setArticle_type(Integer article_type) {
	this.article_type = article_type;
}
public Integer getTemplate_type() {
	return template_type;
}
public void setTemplate_type(Integer template_type) {
	this.template_type = template_type;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getContent_introduction() {
	return content_introduction;
}
public void setContent_introduction(String content_introduction) {
	this.content_introduction = content_introduction;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public Long getWriting_time() {
	return writing_time;
}
public void setWriting_time(Long writing_time) {
	this.writing_time = writing_time;
}
public Long getModification_time() {
	return modification_time;
}
public void setModification_time(Long modification_time) {
	this.modification_time = modification_time;
}
public Integer getBrowse_volume() {
	return browse_volume;
}
public void setBrowse_volume(Integer browse_volume) {
	this.browse_volume = browse_volume;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public String getPictures_url() {
	return pictures_url;
}
public void setPictures_url(String pictures_url) {
	this.pictures_url = pictures_url;
}
public String getAudio_url() {
	return audio_url;
}
public void setAudio_url(String audio_url) {
	this.audio_url = audio_url;
}
@Override
public String toString() {
	return "ArticleEntity [article_id=" + article_id + ", article_type="
			+ article_type + ", template_type=" + template_type + ", title="
			+ title + ", author=" + author + ", content_introduction="
			+ content_introduction + ", content=" + content + ", writing_time="
			+ writing_time + ", modification_time=" + modification_time
			+ ", browse_volume=" + browse_volume + ", status=" + status
			+ ", remarks=" + remarks + ", pictures_url=" + pictures_url
			+ ", audio_url=" + audio_url + "]";
}

	

}
