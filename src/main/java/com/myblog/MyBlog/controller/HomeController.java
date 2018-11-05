package com.myblog.MyBlog.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myblog.MyBlog.model.Post;
import com.myblog.MyBlog.service.PostService;

@Controller
public class HomeController {

	@Autowired
	private PostService postService;
	
	
	@RequestMapping("/")
	public String showHome(Model model) {
		List<Post> mylatest5Post = postService.findLatest5();
		List<Post> myLatest4Post = new ArrayList<Post>();
		Post firstPostForCarousel = null;
		int i = 0;
		for(Post tempPost: mylatest5Post) {
			if(i==0) {
				firstPostForCarousel = tempPost;
			}
			else {
				myLatest4Post.add(tempPost);
				
			}
			i++;
		}
	
		model.addAttribute("firstPost",firstPostForCarousel);
		model.addAttribute("latesPosts", myLatest4Post);
		model.addAttribute("allPosts", postService.findAll());
		return "index";
	}
}
