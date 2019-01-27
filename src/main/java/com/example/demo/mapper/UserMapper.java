package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.UserEntity;

public interface UserMapper {
	
	List<UserEntity> getAll();
	
	List<UserEntity> getAllUsers();
	
	UserEntity getOne(Long id);

	void insert(UserEntity user);
	
	void insertAndReturnKey(UserEntity user);
	
	void insertUsers(List<UserEntity> list);

	void update(UserEntity user);

	void delete(Long id);

	
}
