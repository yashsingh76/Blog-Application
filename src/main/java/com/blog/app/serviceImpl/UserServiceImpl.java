package com.blog.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.app.config.AppConstants;
import com.blog.app.entities.Role;
import com.blog.app.entities.User;
import com.blog.app.exceptionhandler.ResourceNotFoundException;
import com.blog.app.payloads.UserDto;
import com.blog.app.repositories.RoleRepo;
import com.blog.app.repositories.UserRepo;
import com.blog.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepo roleRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.usertoDto(savedUser);
	}

	@Override
	public UserDto upadateUser(UserDto userDto, Integer userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id",userId));
		
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUser = this.userRepo.save(user);
		UserDto userDto1 = this.usertoDto(updatedUser);
		return userDto1;
	}

	@Override
	public UserDto getUserByID(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","id", userId));
		
		return this.usertoDto(user);
	}

	@Override
	public List<UserDto> getAllUsers(){
		
		List<User> users = this.userRepo.findAll();
		
		List<UserDto> userDtos = users.stream().map(user-> this.usertoDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User", "id", userId));
		this.userRepo.delete(user);
	}
	
	private User dtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto, User.class);

		/*
		 * user.setId(userDto.getId());
		 * user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail());
		 * user.setPassword(userDto.getPassword());
		 * user.setAbout(userDto.getAbout());
		 */
		return user; 
	}
	
	private UserDto usertoDto(User user)
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		/*
		 * userDto.setId(user.getId());
		 *  userDto.setName(user.getName());
		 * userDto.setEmail(user.getEmail()); 
		 * userDto.setPassword(user.getPassword());
		 * userDto.setAbout(user.getAbout());
		 */
		return userDto;
	}

	@Override
	public UserDto registerNewUser(UserDto userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		//encode the password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		//role
		Role role = this.roleRepo.findById(AppConstants.NORMAL_USER).get();
		
		user.getRoles().add(role);
		
		User newUser = this.userRepo.save(user);
		return this.modelMapper.map(newUser, UserDto.class);
	}

	

}
