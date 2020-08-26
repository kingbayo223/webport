package com.arkproject.demo.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.arkproject.demo.model.AddItem;
import com.arkproject.demo.model.Role;
import com.arkproject.demo.model.User;
import com.arkproject.demo.repository.RoleRepository;
import com.arkproject.demo.repository.UserRepository;

@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		user.setStatus("VERIFIED");
		Role userRole = roleRepository.findByRole("SITE_USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Override
	public boolean isUserAlreadyPresent(@Valid User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<User> listAll() {
        return userRepository.findAll();
    }

	 public User get(int id) {
	        return userRepository.findById(id).get();
	    }

	@Override
	public void delete(int id) {

		        userRepository.deleteById(id);
			    // TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(int id) {
		 userRepository.deleteById(id);
		
	}
	
	
}
