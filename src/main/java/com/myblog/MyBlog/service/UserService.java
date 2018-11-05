package com.myblog.MyBlog.service;

import com.myblog.MyBlog.model.User;

public interface UserService {

	void save(User user);
	User findByUsername(String username);
}
