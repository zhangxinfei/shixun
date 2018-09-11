package com.software.service;

import com.software.dao.UsersDao;
import com.software.domain.Users;

public class UsersService {
	UsersDao userDao=new UsersDao();

	public boolean login(String userId,String password,String flag){
		return userDao.login(userId,password,flag);
	}
	
	public boolean register(Users user){
		return userDao.register(user);
	}
	
	public boolean registerCheck(String userId){
		return userDao.registerCheck(userId);
	}
}
