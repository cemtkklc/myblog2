package com.myblog.MyBlog.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myblog.MyBlog.model.Image;
import com.myblog.MyBlog.service.ImageService;

@Controller
@RequestMapping("/image")
public class ImageController {

	@Autowired
	private ImageService imageService;
	
	@GetMapping("/imageDisplay")
	public void showSingleImage(@RequestParam("id") Integer imageId, HttpServletResponse response, HttpServletRequest request )
	throws ServletException, IOException
	{
		Long imageLongid = imageId.longValue();
		Image tempImage = imageService.findById(imageLongid);
		response.setContentType(tempImage.getType());
		response.getOutputStream().write(tempImage.getPic());
		response.getOutputStream().close();
		
	}
	
	
}
