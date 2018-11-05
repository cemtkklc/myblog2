package com.myblog.MyBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.MyBlog.Dao.CategoryRepository;
import com.myblog.MyBlog.model.Category;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category findByName(String name) {
		// TODO Auto-generated method stub
		return categoryRepository.findByName(name);
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).orElse(null);
	}

}
