package com.tgb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tgb.model.User;

@Mapper
public interface UserMapper {

	public void save(User user);

	public void delete(String id);

	public void update(User user);

	public User getById(String id);

	public List<User> getAll();

}
