package com.bootdo.zallhy.service;

import com.bootdo.zallhy.domain.HyUserDO;

import java.util.List;
import java.util.Map;

/**
 * 汉艺user表
 * 
 * @author barry
 * @email 1992lcg@163.com
 * @date 2017-12-26 14:41:55
 */
public interface HyUserService {
	
	HyUserDO get(String userId);
	
	List<HyUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HyUserDO hyUser);
	
	int update(HyUserDO hyUser);
	
	int remove(String userId);
	
	int batchRemove(String[] userIds);
}
