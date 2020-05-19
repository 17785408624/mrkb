package com.mrkb.common.utils.globalStatic;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public class GlobalStatic {
    public static final Map<String, Object> map = new HashMap<String, Object>();
    public static final JSONObject json = JSONObject.fromString("{"
            //上级为三星紫罗兰
            + "'share21':0.3,"//购买前端课程
            + "'share22':0.2,"//购买品牌课程
            + "'share23':0,"//购买精品课程
            + "'share24':0,"
            + "'share25':0,"
            + "'share29':0,"
            //上级为五星紫罗兰
            + "'share31':0.4,"//购买前端课程
            + "'share32':0.3,"//购买品牌课程
            + "'share33':0.2,"//购买精品课程
            + "'share34':5000,"//购买专业课程
            + "'share35':0.15,"
            + "'share39':0,"
            //上级为紫罗兰之家
            + "'share41':0.5,"//购买前端课程
            + "'share42':0.4,"//购买品牌课程
            + "'share43':0.2,"//购买精品课程
            + "'share44':5000,"//购买专业课程
            + "'share45':0.15,"//购买乐唐大学
            + "'share49':0,"
            //上级为紫罗兰联盟
            + "'share51':0.7,"//购买前端课程
            + "'share52':0.5,"//购买品牌课程
            + "'share53':0.25,"//购买精品课程
            + "'share54':10000,"//购买专业课程
            + "'share55':0.18,"//购买乐唐大学
            + "'share59':0,"
            //上级为紫罗兰分院
//			+ "'share61':0.7,"//购买前端课程
//			+ "'share62':0.5,"//购买品牌课程
//			+ "'share63':0.35,"//购买精品课程
//			+ "'share64':5000,"//购买专业课程
//			+ "'share65':0.15,"//购买乐唐大学
//			+ "'share69':0,"
            //上级为员工
            + "'share71':0.4,"//购买前端课程
            + "'share72':0.16,"//购买品牌课程
            + "'share73':0.08,"//购买精品课程
            + "'share74':2000,"//购买专业课程
            + "'share75':0.08,"//购买乐唐大学
            + "'share79':0"
            + "}");//将字符串转换为JSONObject对象
    //上级为三星紫罗兰
    public static final double share21 = 0.3;//购买前端课程
    public static final double share22 = 0.2;//购买品牌课程
    public static final String share23 = "";//购买精品课程
    public static final String share24 = "";
    public static final String share25 = "";
    public static final String share29 = "";
    //上级为五星紫罗兰
    public static final double share31 = 0.4;//购买前端课程
    public static final double share32 = 0.3;//购买品牌课程
    public static final double share33 = 0.2;//购买精品课程
    public static final Integer share34 = 5000;//购买专业课程
    public static final double share35 = 0.15;
    public static final String share39 = "";
    //上级为钻石紫罗兰
    public static final double share41 = 0.5;//购买前端课程
    public static final double share42 = 0.4;//购买品牌课程
    public static final double share43 = 0.2;//购买精品课程
    public static final Integer share44 = 5000;//购买专业课程
    public static final double share45 = 0.15;//购买乐唐大学
    public static final String share49 = "";
    //上级为紫罗兰联盟
    public static final double share51 = 0.7;//购买前端课程
    public static final double share52 = 0.5;//购买品牌课程
    public static final double share53 = 0.25;//购买精品课程
    public static final Integer share54 = 10000;//购买专业课程
    public static final double share55 = 0.18;//购买乐唐大学
    public static final String share59 = "";
    //上级为紫罗兰分院
//	public static final double share61=0.7;//购买前端课程
//	public static final double share62=0.5;//购买品牌课程
//	public static final double share63=0.35;//购买精品课程
//	public static final Integer share64=5000;//购买专业课程
//	public static final double share65=0.15;//购买乐唐大学
//	public static final String share69="";
    //上级为员工
  /*  public static final double share71 = 0.4;//购买前端课程
    public static final double share72 = 0.16;//购买品牌课程
    public static final double share73 = 0.08;//购买精品课程
    public static final Integer share74 = 2000;//购买专业课程
    public static final double share75 = 0.08;//购买乐唐大学
    public static final String share79 = "";*/

    // 基金
    public static final double fund_money = 0.01;// 基金商品比例
    // 推荐送积分
    public static final Integer share_conver_num = 0;// 基金商品比例
    public static String imgUrlGet = "http://www.szltvip.cn:8080/file";
    public static String imgUrlSet = "C:\\file\\";
    // 奖金池
    public static final Integer useGreen_kaba = 1800;//绿卡巴兑换奖金池所需积分
    public static final Integer useIndigo_kaba = 5400;//青卡巴兑换奖金池所需积分
    public static final Integer useBlue_violet_kaba = 16200;//蓝卡巴兑换奖金池所需积分
    public static final Integer usePurple_kaba = 48600;//紫卡巴兑换奖金池所需积分

}
