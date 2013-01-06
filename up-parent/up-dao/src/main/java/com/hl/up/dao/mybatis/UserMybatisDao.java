package com.hl.up.dao.mybatis;

import java.util.List;
import java.util.Map;

import com.hl.up.pojo.User;

@MyBatisRepository
public interface UserMybatisDao {
	
	User get(Long id);

	List<User> search(Map<String, Object> parameters);

	void save(User user);

	void delete(Long id);
}
