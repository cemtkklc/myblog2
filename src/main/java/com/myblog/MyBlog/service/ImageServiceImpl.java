package com.myblog.MyBlog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myblog.MyBlog.Dao.ImageRepository;
import com.myblog.MyBlog.model.Image;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	private ImageRepository imageRepository;
	
	@Override
	public void save(Image image) {
		imageRepository.save(image);

	}

	@Override
	public Image findById(Long id) {
		// TODO Auto-generated method stub
		return imageRepository.findById(id).orElse(null);
	}

}
