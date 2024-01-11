package com.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entity.comment;

@Repository
public interface CommentRepo extends JpaRepository<comment, Integer>{
	
	 List<comment> findByblogId(int id);
}
