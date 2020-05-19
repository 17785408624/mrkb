package com.mrkb.dao.modle.weixin.menu;

/**
* 类名: ComplexButton
* 描述: 父菜单项 :包含有二级菜单项的一级菜单。这类菜单项包含有二个属性：name和sub_button，而sub_button以是一个子菜单项数组
* 开发人员： 万祖权  
* 创建时间：  2017-12-27 
 */
public class ComplexButton extends Button {
    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}