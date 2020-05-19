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
public class SysUser {

	private Integer id;//管理员ID
	private String username;//用户名
	private String password;//用户密码
	private Long create_time;//创建时

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public Long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SysUser{" +
				"id=" + id +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", create_time=" + create_time +
				'}';
	}
}