package com.itheima.dao;

import java.util.List;

import com.itheima.common.dao.BaseDao;
import com.itheima.domain.User;

public interface UserDao extends BaseDao<User, String> {
	/**
	 * 根据用户名查用户
	 * 
	 * @param userName
	 * @return
	 */
	List<User> findByUserName(String userName);
}
