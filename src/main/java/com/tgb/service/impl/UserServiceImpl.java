package com.tgb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tgb.mapper.UserMapper;
import com.tgb.model.User;
import com.tgb.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;

	@Override
	public List<User> getAll() {
		return userMapper.getAll();
	}

	@Override
	public void save(User user) {
		userMapper.save(user);
	}

	@Override
	public void delete(String id) {
		userMapper.delete(id);
	}

	@Override
	public void update(User user) {
		userMapper.update(user);
	}

	@Override
	public User getById(String id) {
		return userMapper.getById(id);
	}

}
