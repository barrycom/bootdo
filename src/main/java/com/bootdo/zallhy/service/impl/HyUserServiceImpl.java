package com.bootdo.zallhy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.bootdo.zallhy.dao.HyUserDao;
import com.bootdo.zallhy.domain.HyUserDO;
import com.bootdo.zallhy.service.HyUserService;



@Service
public class HyUserServiceImpl implements HyUserService {
	@Autowired
	private HyUserDao hyUserDao;
	
	@Override
	public HyUserDO get(String userId){
		return hyUserDao.get(userId);
	}
	
	@Override
	public List<HyUserDO> list(Map<String, Object> map){
		return hyUserDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return hyUserDao.count(map);
	}
	
	@Override
	public int save(HyUserDO hyUser){
		return hyUserDao.save(hyUser);
	}
	
	@Override
	public int update(HyUserDO hyUser){
		return hyUserDao.update(hyUser);
	}
	
	@Override
	public int remove(String userId){
		return hyUserDao.remove(userId);
	}
	
	@Override
	public int batchRemove(String[] userIds){
		return hyUserDao.batchRemove(userIds);
	}
	
}
