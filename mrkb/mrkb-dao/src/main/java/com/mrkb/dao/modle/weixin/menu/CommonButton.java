package com.mrkb.dao.modle.weixin.menu;


/**
* 类名: CommonButton 
* 描述: 子菜单项 :没有子菜单的菜单项，有可能是二级菜单项，也有可能是不含二级菜单的一级菜单。
* 开发人员： 万祖权
* 创建时间：  2017-12-27 
 */
public class CommonButton extends Button {
    
    private String type;
    private String key;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}