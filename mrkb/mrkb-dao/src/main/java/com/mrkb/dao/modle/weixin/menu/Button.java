package com.mrkb.dao.modle.weixin.menu;

/**
* 类名: Button 
* 描述: 菜单项的基类 
* 开发人员： 万祖权 
* 创建时间：  2017-12-27
 */
public class Button {
    
    private String name;//所有一级菜单、二级菜单都共有一个相同的属性，那就是name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}