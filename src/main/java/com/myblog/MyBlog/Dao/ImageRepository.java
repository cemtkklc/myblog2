package com.myblog.MyBlog.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myblog.MyBlog.model.Image;
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
