package com.myblog.MyBlog.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myblog.MyBlog.Dao.UserRepository;
import com.myblog.MyBlog.model.User;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByUsername(username);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		if(user.getRoles() == null) {
			grantedAuthorities.add(new SimpleGrantedAuthority("default"));
		}
		grantedAuthorities.add(new SimpleGrantedAuthority("default"));
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),grantedAuthorities);
	}

}
