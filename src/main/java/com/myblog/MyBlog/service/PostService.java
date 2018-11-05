package com.myblog.MyBlog.service;

import java.util.List;
import java.util.Optional;


import com.myblog.MyBlog.model.Post;

public interface PostService {

	List<Post> findAll();
	
	List<Post> findLatest5();
	List<Post> findByAuthorName(String username);
	Optional<Post> findById(Long id);
	List<Post> findByCategory(String categoryName);
	Post create(Post post);
	Post update(Post post);
	void deleteById(Long id);
}
