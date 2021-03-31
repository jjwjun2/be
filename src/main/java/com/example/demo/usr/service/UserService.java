package com.example.demo.usr.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.usr.domain.MailDto;
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

//	public boolean idFormatCheck(String id);
//	public boolean mailFormatCheck(String id);
//	public boolean nameFormatCheck(String usrName);
//	public boolean nickNameFormatCheck(String nickName);
//	public boolean phoneFormatCheck(String phone);
	

	public MailDto createMailAndChangePassword(String userName, String userEmail);
	public void updatePassword(String str, String userEmail);
	public String createTempPassword();
	public void mailSend(MailDto mailDto);
	
}