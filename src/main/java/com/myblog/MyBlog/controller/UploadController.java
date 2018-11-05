package com.myblog.MyBlog.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/upload")
public class UploadController {

	
	
	private static String uploadfolder= "C://Users//Public//";
	
	@GetMapping("/")
	public String uploadPage() {
		return "upload";
	}
	
	@PostMapping("/upload")
	public String afterUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
		
		if(file.isEmpty()) {
			return "redirect:/";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(uploadfolder + file.getOriginalFilename());
			Files.write(path, bytes);
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return "redirect:/";
	}
	
	
}
