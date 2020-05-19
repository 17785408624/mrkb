package com.mrkb.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mrkb.dao.modle.pagestructure.MenuEntity;

@Mapper
public interface MeusMapper {
	/**
	 * 
	 * @Title:             insertMeus
	 * @Description:     TODO 插入一条菜单栏记录
	 * @param:             @param menuEntity 菜单栏实体类
	 * @param:             @return   
	 * @return:         int  
	 * @throws
	 */
	int insertMeus(MenuEntity menuEntity);//插入一条菜单栏记录
	/**
	 * 
	 * @Title:             selectMenuToMenuCN_MenuS_MenuN
	 * @Description:     TODO 查询菜单栏
	 * @param:             @param menu_code_num 菜单对应终端
	 * @param:             @param menu_series 菜单级数 
	 * @param:             @param menu_nature 菜单性质 
	 * @param:             @return 符合条件的菜单栏集合 
	 * @return:         List<MenuEntity> 菜单栏实体类集合 
	 * @throws
	 */
	List<MenuEntity> selectMenuToMenuCN_MenuS_MenuN(
			@Param("menu_code_num")Integer menu_code_num,
			@Param("menu_series")Integer menu_series,
			@Param("menu_nature")Integer menu_nature);//查询菜单栏
	/**
	 * 
	 * @Title:             selectMenuToMenuCN_MenuN
	 * @Description:     TODO 查询菜单栏
	 * @param:             @param menu_code_num 菜单对应终端
	 * @param:             @param menu_nature 菜单性质 
	 * @param:             @return   
	 * @return:         List<MenuEntity>   
	 * @throws
	 */
	List<MenuEntity> selectMenuToMenuCN_MenuN(
			@Param("menu_code_num")Integer menu_code_num,
			@Param("menu_nature")Integer menu_nature);//查询菜单栏
	/**
	 * 
	 * @Title:             likeSelectMenuToMenu_url
	 * @Description:     TODO 根据url链接模糊查询页面菜单
	 * @param:             @param menu_url 菜单url链接
	 * @param:             @return   
	 * @return:         List<MenuEntity>   
	 * @throws
	 */
	List<MenuEntity> likeSelectMenuToMenu_url(String menu_url);//根据url链接模糊查询页面菜单
	
	/**
	 * 
	 * @Title:             deleteMenuToMid
	 * @Description:     TODO 根据菜单id参数删除一条菜单数据
	 * @param:             @param menu_id 菜单id
	 * @param:             @return   
	 * @return:         int   返回1删除成功
	 * @throws
	 */
	int deleteMenuToMid(int menu_id);//根据菜单id参数删除一条菜单数据
	

}
