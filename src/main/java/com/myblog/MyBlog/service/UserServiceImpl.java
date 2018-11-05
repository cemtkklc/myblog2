package com.myblog.MyBlog.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myblog.MyBlog.Dao.RoleRepository;
import com.myblog.MyBlog.Dao.UserRepository;
import com.myblog.MyBlog.model.Role;
import com.myblog.MyBlog.model.User;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	/* Old BcryptPassword encoder changed by PasswordEncoder respect to the Spring Security Version
	@Autowired 
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	*/
	@Override
	public void save(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		Role role = roleRepository.findById(1L).orElse(null);

		Set<Role> roleList = new HashSet<>();
		roleList.add(role);
		user.setRoles(roleList);
		userRepository.save(user);
		
	}

	@Override
	public User findByUsername(String username) {
		// TODO Auto-generated method stub
		return userRepository.findByUsername(username);
	}

}
