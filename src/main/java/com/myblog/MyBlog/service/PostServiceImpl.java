package com.myblog.MyBlog.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.myblog.MyBlog.Dao.PostRepository;
import com.myblog.MyBlog.model.Post;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepo;
	
	@Override
	public List<Post> findAll() {
		// TODO Auto-generated method stub
		return this.postRepo.findAll();
	}

	@Override
	public List<Post> findLatest5() {
		// TODO Auto-generated method stub
		return this.postRepo.findAll().stream().
				sorted((a,b) -> b.getDate().compareTo(a.getDate())).
				limit(5)
				.collect(Collectors.toList());
	}

	@Override
	public Optional<Post> findById(Long id) {
		// TODO Auto-generated method stub
		return this.postRepo.findById(id);
	}

	@Override
	public Post create(Post post) {
		// TODO Auto-generated method stub
		return this.postRepo.save(post);
	}

	@Override
	public Post update(Post post) {
		// TODO Auto-generated method stub
		Post tempPost = this.postRepo.findById(post.getId()).orElse(null);
		tempPost.setTitle(post.getTitle());
		
		tempPost.setBody(post.getBody());
		tempPost.setDate(post.getDate());
		tempPost.setAuthor(post.getAuthor());
		tempPost.setCategory(post.getCategory());
		tempPost.setImage(post.getImage());
		return tempPost;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		this.postRepo.deleteById(id);
	}

	@Override
	public List<Post> findByAuthorName(String username) {
		// TODO Auto-generated method stub
		return postRepo.findByAuthorName(username);
	}

	@Override
	public List<Post> findByCategory(String categoryName) {
		// TODO Auto-generated method stub
		
		
		return postRepo.findbyCategory(categoryName);
	}

	

}
