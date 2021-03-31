package com.example.demo.usr.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.usr.domain.User;
import com.example.demo.usr.domain.UserDto;

public interface UserService {
	
	public boolean checkDuplicateId(String userId);
	public boolean checkDuplicateEmail(String userId);
	public List<User> findUsersByName(String name);
	public List<User> findAllUser();
	public String findIdByEmail(String userEmail);
	public UserDto create(UserDto user);
	
	
	public Optional<User> updateProfile(User user);
	
	public boolean emailCheck(User user);
	public boolean idCheck(User user);	
	public boolean swearFilter(String keyword);
	

	public void updatePassword(String str, String userEmail);
	public String createTempPassword();
	
}