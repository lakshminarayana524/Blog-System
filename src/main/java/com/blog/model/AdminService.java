package com.blog.model;


import java.util.List;

import com.blog.entity.Admin;
import com.blog.entity.CreateBlog;
import com.blog.entity.User;
import com.blog.entity.comment;

public interface AdminService {
	
	public List<User> viewalluser();
	public User viewallbyid(int id);
	public Admin checkadminlogin(String email,String pass);
	public List<CreateBlog> viewallblogs();
	public CreateBlog viewallbyblogid(int id);
	public comment viewallcommentbyid(int id);
	public String deleteuser(int id);
	public String deletepost(int id);
	public String deletecomment(int id);
	public String deletecommentadmin(int id);
	public List<comment> ViewallComments();
	public List<comment> viewallcommentwithid(int id);
	public long countuser();
	
}
