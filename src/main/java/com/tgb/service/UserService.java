package com.tgb.service;

import java.util.List;

import com.tgb.model.User;

public interface UserService {

	public void save(User user);

	public void delete(String id);

	public void update(User user);

	public User getById(String id);

	public List<User> getAll();
}
