package com.mrkb.common.util;


import static com.sun.javafx.util.Utils.split;

/**
 * 检测是否含有sql注入
 */
public class SqlCheck {


    public static boolean sql_init(String str){
        String init_str = "'|and|exec|insert|select|delete|update| count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,";
        String init_stra[] = split(init_str,"|");
        for (int i=0 ; i <= init_stra.length ; i++ ){
            if (str.equals(init_stra[i])){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        System.out.println(sql_init("inserts"));
    }
}
