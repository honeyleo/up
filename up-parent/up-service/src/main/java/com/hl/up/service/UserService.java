package com.hl.up.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.hl.up.dao.mybatis.UserMybatisDao;
import com.hl.up.pojo.User;

@Service
public class UserService {
	
	@Autowired
	UserMybatisDao userDao;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void save(User user) {
		userDao.save(user);
		jdbcTemplate.execute("insert into t_user(login_name) values(peng2)");
	}
	
	public User get(long id) {
		return userDao.get(id);
	}

}
