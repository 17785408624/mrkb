package com.mrkb.service;


import com.mrkb.dao.modle.store.Business;

import java.util.List;

public interface BusinessService {

    int add(Business business);//添加商家
    List<Business> findAll(Business bankEntity);//查询所有银行卡信息
    Business findById(Business bankEntity);//查询银行卡信息通过card_id
    int update(Business bankEntity);//修改银行卡信息
    int delete(Business bankEntity);//删除银行卡信息
}
