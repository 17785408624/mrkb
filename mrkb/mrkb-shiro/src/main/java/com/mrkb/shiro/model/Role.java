/**
 * FileName: Role
 * Author:   Administrator
 * Date:     2017/12/2 20:19
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mrkb.shiro.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 角色
 * @author Administrator
 * @create 2017/12/2
 * @since 1.0.0
 */
public class Role {

	//主键ID
    private Integer id;
    //角色编码
    private String code;
    //角色名称
    private String name;
    //创建时间
    private Date create_time;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = new Date();
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", code=" + code + ", name=" + name + ", create_time=" + create_time + "]";
	}

}