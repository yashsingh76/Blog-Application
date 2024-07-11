package com.blog.app.services;

import java.util.List;

import com.blog.app.payloads.UserDto;


public interface UserService {
	
	UserDto registerNewUser(UserDto userDto);
	
	
	UserDto createUser(UserDto user);
	UserDto upadateUser(UserDto user,Integer userId);
	UserDto getUserByID(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUser(Integer userId);

}
