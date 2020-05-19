package com.mrkb.service;

import com.mrkb.dao.modle.BizUser;

import java.util.List;
import java.util.Map;

public interface BizUserService {

    public int save(BizUser users);

    public List<Map<String, Object>> getObject();

    public int update(Map<String, String> map);

    public int delete(Map<String, String> map);
}
