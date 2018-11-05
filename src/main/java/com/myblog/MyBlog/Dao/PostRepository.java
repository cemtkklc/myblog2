package com.myblog.MyBlog.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.myblog.MyBlog.model.Post;
@Repository
public interface PostRepository extends PagingAndSortingRepository<Post, Long>{

	
	@Query("SELECT p FROM Post p LEFT JOIN FETCH p.author ORDER BY p.date DESC")
	List<Post> findAll();
	@Query("Select p from Post p where p.author.username = ?1")
	List<Post> findByAuthorName(String username);
	@Query("Select p From Post p Where p.category.name = ?1")
	List<Post> findbyCategory(String categoryName);
	
	
}
