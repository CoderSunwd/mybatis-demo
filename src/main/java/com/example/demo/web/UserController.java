package com.example.demo.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.UserEntity;
import com.example.demo.enums.UserSexEnum;
import com.example.demo.mapper.UserMapper;

@RestController
public class UserController {
	
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("/getUsers")
	public List<UserEntity> getUsers() {
		List<UserEntity> users=userMapper.getAll();
		return users;
	}
	
	@RequestMapping("/getAllUsers")
	public List<UserEntity> getAllUsers() {
		List<UserEntity> users=userMapper.getAllUsers();
		return users;
	}
	
    @RequestMapping("/getUser")
    public UserEntity getUser(Long id) {
    	UserEntity user=userMapper.getOne(id);
        return user;
    }
    
    @RequestMapping("/add")
    public void save(UserEntity user) {
    	userMapper.insert(user);
    }
    
    @RequestMapping("/addAndReturnKey")
    public long saveAndReturnKey(UserEntity user) {
    	userMapper.insertAndReturnKey(user);
    	return user.getId();
    }
    
    @RequestMapping("/addUsers")
    public List<UserEntity> saveUsers() {
    	List<UserEntity> list = new ArrayList<UserEntity>();
    	UserEntity user = new UserEntity("ff1", "11", UserSexEnum.MAN);
    	list.add(user);
    	user = new UserEntity("ff2", "22", UserSexEnum.MAN);
    	list.add(user);
    	user = new UserEntity("ff3", "33", UserSexEnum.MAN);
    	list.add(user);
    	userMapper.insertUsers(list);
    	return list;
    }
    
    @RequestMapping(value="update")
    public void update(UserEntity user) {
    	userMapper.update(user);
    }
    
    @RequestMapping(value="/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
    	userMapper.delete(id);
    }

        
}
