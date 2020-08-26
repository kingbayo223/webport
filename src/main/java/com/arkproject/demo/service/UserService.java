package com.arkproject.demo.service;

import java.util.List;

import javax.validation.Valid;


import com.arkproject.demo.model.User;

public interface UserService {

	public void saveUser(User user);
	
	public boolean isUserAlreadyPresent(@Valid User user);

	public List<User> listAll();
	
	 public User get(int id);

	public void delete(int id);

	public void deleteUser(int id);

	
}
