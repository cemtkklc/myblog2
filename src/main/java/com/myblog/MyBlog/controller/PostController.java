package com.myblog.MyBlog.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myblog.MyBlog.model.Category;
import com.myblog.MyBlog.model.Image;
import com.myblog.MyBlog.model.Post;
import com.myblog.MyBlog.model.User;
import com.myblog.MyBlog.service.CategoryService;
import com.myblog.MyBlog.service.ImageService;
import com.myblog.MyBlog.service.PostService;
import com.myblog.MyBlog.service.UserService;

@Controller
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private PostService postService;
	@Autowired
	private ImageService imageService;
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/createpost")
	public String createPost(Model model) {
		Post tempPost = new Post();
		model.addAttribute("tempPost",tempPost);
		return "createpost";
	}
	
	@PostMapping("/createPostProcess")
	public String createPostProcess(@RequestParam("file") MultipartFile file,@ModelAttribute("tempPost") Post post,@ModelAttribute("categories") String categoryName,RedirectAttributes redirectAttributes,Principal principal) {
		String username=principal.getName();
			if(username==null)
				return "index";
		User tempUser = userService.findByUsername(username);
		Category tempCategory = categoryService.findByName(categoryName);
		Date tempDate = new Date(System.currentTimeMillis());
		post.setDate(tempDate);
		post.setAuthor(tempUser);
		post.setCategory(tempCategory);
		Image tempImage = new Image();
		if(file.isEmpty()) {
			return "redirect:/";
		}
		try {
			byte[] bytes = file.getBytes();
			String fileName= file.getName();
			String typeName = file.getContentType();
			//Image tempImage = new Image();
			tempImage.setName(fileName);
			tempImage.setType(typeName);
			tempImage.setPic(bytes);
			imageService.save(tempImage);
			//Path path = Paths.get(uploadfolder + file.getOriginalFilename());
			//Files.write(path, bytes);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		post.setImage(tempImage);
		postService.create(post);
		return "index";	
	}
	@GetMapping("/myposts")
	public String getUserPosts(Model model,Principal principal) {
		String username =principal.getName(); 
		List<Post> postList = postService.findByAuthorName(username);
		model.addAttribute("postList" , postList);
		return "myposts";
	}
	@GetMapping("/getPost")
	public String getSinglePost(@RequestParam("id") Integer postId, Model model) {
		Long postIdLong = postId.longValue();	
		Post tempPost = postService.findById(postIdLong).orElse(null);
		model.addAttribute("singlePost",tempPost);
		
		return "singlepost";
	}
	@GetMapping("/getCategory")
	public String getCategoryPost(@RequestParam("categoryName")String categoryName, Model model) {
		model.addAttribute("postList", postService.findByCategory(categoryName));
		
		return "categorypostlist";
	}
	
}
