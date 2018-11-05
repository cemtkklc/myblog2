package com.myblog.MyBlog.service;
import com.myblog.MyBlog.model.Image;;
public interface ImageService {
	void save(Image image);
	Image findById(Long id);
}
