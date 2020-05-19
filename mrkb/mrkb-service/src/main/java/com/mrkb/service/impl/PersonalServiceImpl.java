package com.mrkb.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mrkb.dao.dao.PersonalMapper;
import com.mrkb.dao.modle.personal.PersonalMode;
import com.mrkb.dao.modle.personal.PersonalServer;
import com.mrkb.dao.modle.personal.PersonalType;
import com.mrkb.service.PersonalService;



@Service
@Transactional
public class PersonalServiceImpl implements PersonalService{
	@Resource
	private PersonalMapper personalMapper;

	@Override
	public PersonalServer addServer(PersonalServer personalServer) {
		personalMapper.addServer(personalServer);
		return personalServer;
	}
	@Override
	public PersonalType addType(PersonalType personalType) {
		personalMapper.addType(personalType);
		return personalType;
	}
	@Override
	public List<PersonalType> findPersonalType(HashMap<String, Object> map) {
		return personalMapper.findPersonalType(map);
	}
	@Override
	public int deletePersonalType(HashMap<String,Object> map) {
		return personalMapper.deletePersonalType(map);
	}
	@Override
	public PersonalMode addMode(PersonalMode personalMode) {
		personalMapper.addMode(personalMode);
		return personalMode;
	}
	@Override
	public List<PersonalMode> findPersonalMode(HashMap<String, Object> map) {
		return personalMapper.findPersonalMode(map);
	}
	@Override
	public List<PersonalServer> findPersonalSver(HashMap<String, Object> map) {
		return personalMapper.findPersonalSver(map);
	}
	@Override
	public PersonalServer findPersonalSverOne(HashMap<String, Object> map) {
		return personalMapper.findPersonalSverOne(map);
	}
	@Override
	public List<PersonalServer> findBagSver(List<Integer> list) {
		return personalMapper.findBagSver(list);
	}

	@Override
	public PersonalServer findPersonalByServerId(HashMap<String, Object> map) {
		return personalMapper.findPersonalByServerId(map);
	}
	
	@Override
	public int updatePersonalSver(PersonalServer personalServer) {
		return personalMapper.updatePersonalSver(personalServer);
	}
}
