package com.bootdo.zallhy.dao;

import com.bootdo.zallhy.domain.HyUserDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 汉艺user表
 * @author barry
 * @email 1992lcg@163.com
 * @date 2017-12-26 14:41:55
 */
@Mapper
public interface HyUserDao {

	HyUserDO get(String userId);
	
	List<HyUserDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(HyUserDO hyUser);
	
	int update(HyUserDO hyUser);
	
	int remove(String user_id);
	
	int batchRemove(String[] userIds);
}
