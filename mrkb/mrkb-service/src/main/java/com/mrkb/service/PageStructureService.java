package com.mrkb.service;

import java.util.List;

import com.mrkb.dao.modle.pagestructure.MenuEntity;


public interface PageStructureService {
	/**
	 * 
	 * @Title:             addMenu
	 * @Description:     TODO 添加一条菜单数据
	 * @param:             @param menuEntity
	 * @param:             @return   
	 * @return:         int   
	 * @throws
	 */
	int addMenu(MenuEntity menuEntity);
	/**
	 * 
	 * @Title:             findMenuToMenuCN_MenuS_MenuN
	 * @Description:     TODO 查询符合条件的菜单栏
	 * @param:             @param menu_code_num 对应的终端code
	 * @param:             @param menu_series 菜单栏级数
	 * @param:             @param menu_nature 菜单栏性质
	 * @param:             @return   
	 * @return:         List<MenuEntity>   菜单栏集合
	 * @throws
	 */
	List<MenuEntity> findMenuToMenuCN_MenuS_MenuN(
			Integer menu_code_num,Integer menu_series,Integer menu_nature);//查询符合条件的菜单栏
	/**
	 * 
	 * @Title:             likeFindMenuToMenu_url
	 * @Description:     TODO 根据url链接模糊查询页面菜单
	 * @param:             @param menu_url 菜单链接url
	 * @param:             @return   
	 * @return:         List<MenuEntity>   
	 * @throws
	 */
	List<MenuEntity> likeFindMenuToMenu_url(String menu_url);//根据url链接模糊查询页面菜单
	/**
	 * 
	 * @Title:             findMenuToMenu_series
	 * @Description:     TODO 根据菜单级数查询菜单数据
	 * @param:             @param menu_series 菜单级数
	 * @param:             @return   
	 * @return:         List<MenuEntity>   
	 * @throws
	 */
	List<MenuEntity> findMenuToMenu_series(int menu_series,int menu_nature,int menu_code_num);//根据菜单级数查询菜单数据
    /**
     * 
     * @Title:             removeMenuOne
     * @Description:     TODO 删除一条菜单数据
     * @param:             @param menu_id   菜单id
     * @return:         void   
     * @throws
     */
	public void removeMenuOne(int menu_id);//删除一条菜单数据
}
