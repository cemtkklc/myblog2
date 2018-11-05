package com.myblog.MyBlog.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myblog.MyBlog.model.User;
import com.myblog.MyBlog.service.SecurityService;
import com.myblog.MyBlog.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	
	@RequestMapping("/login")
	public String openLoginPage() {
		return "login";
	}
	@PostMapping("/authUser")
	public String authUser() {
		return "redirect:/";
	}
	
	@GetMapping("/register")
	public String registerClick(Model model) {
		model.addAttribute("userForm", new User());
		return "register";
	}
	
	@PostMapping("/registerAuth")
	public String registerUser(@ModelAttribute("userForm")@Valid User userForm,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			//notificationService.addErrorMessage("Fill form correct!");
			return "redirect:/register";
		}
		String originalPassword= userForm.getPassword();
		userService.save(userForm);
		securityService.autologin(userForm.getUsername(),originalPassword);
		
		return "redirect:/";
		
	}
}
