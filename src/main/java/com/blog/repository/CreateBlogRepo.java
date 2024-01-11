package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.CreateBlog;

@Repository
public interface CreateBlogRepo extends JpaRepository<CreateBlog, Integer>{

}
