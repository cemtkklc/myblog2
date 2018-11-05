package com.myblog.MyBlog.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myblog.MyBlog.model.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
