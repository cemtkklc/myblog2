package com.myblog.MyBlog.service;

import com.myblog.MyBlog.model.Category;

public interface CategoryService {

	Category findByName(String name);
	Category findById(Long id);
}
