package com.praveen.app.service;

import java.util.List;

import com.praveen.app.entity.Users;

public interface UsersService {
	List<Users> getAll();

	void saveUser(Users user);

	Users getById(int id);
	
	void delUser(int id);
}
