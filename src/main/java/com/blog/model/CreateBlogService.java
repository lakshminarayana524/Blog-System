package com.blog.model;

import java.util.List;

import com.blog.entity.CreateBlog;
import com.blog.entity.comment;

public interface CreateBlogService {

	public String Addblog(CreateBlog cb);
	public List<CreateBlog> viewAllBlog();
	public CreateBlog viewallblogsbyid(int id);
	void addCommentToPost(int Id, comment comment);
	public CreateBlog getBlogWithComments(int id);
}
