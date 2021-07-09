package com.praveen.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.praveen.app.entity.Users;
import com.praveen.app.repository.UsersRepository;

@Service
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UsersRepository dao;

	@Override
	public List<Users> getAll() {
		return dao.findAll();
	}

	@Override
	public void saveUser(Users user) {
		this.dao.save(user);
	}

	@Override
	public Users getById(int id) {
		Optional<Users> user = dao.findById(id);
		Users us=null;
		if(user.isPresent()) {
			us=user.get();
		}
		else {
			throw new RuntimeException("Employee not found for id ::"+id);
		}
		return us;
	}

	@Override
	public void delUser(int id) {
		dao.deleteById(id);
	}

}
