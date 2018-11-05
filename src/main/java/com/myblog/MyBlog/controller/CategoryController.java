package com.myblog.MyBlog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myblog.MyBlog.model.Category;
import com.myblog.MyBlog.service.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/getName/{id}")
	public String getNamefromId(@PathVariable Integer id) {
		Long lonId = id.longValue();
		Category tempCate = categoryService.findById(lonId);
		
		
		return tempCate.getName();
	}
	
}
