package com.blog.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.CreateBlog;
import com.blog.entity.comment;
import com.blog.repository.CommentRepo;
import com.blog.repository.CreateBlogRepo;

@Service
public class CreateBlogManger  implements CreateBlogService{
	
	@Autowired
	CreateBlogRepo cr;
	
	@Autowired
	CommentRepo cor;

	@Override
	public String Addblog(CreateBlog cb) {
		 cr.save(cb);
		 return "Successfully Added";
		
	}

	@Override
	public List<CreateBlog> viewAllBlog() {
		// TODO Auto-generated method stub
		return (List<CreateBlog>) cr.findAll() ;
	}

	@Override
	public CreateBlog viewallblogsbyid(int id) {
		Optional<CreateBlog> obj=cr.findById(id);
		if(obj.isPresent()) {
			CreateBlog cb=obj.get();
			return cb;
		}
		else {
			return null;
		}
	}
	
	public List<CreateBlog> viewallblogbyuidSortedByUid(int uid) {
	    return cr.findByUidIdOrderByUidId(uid);
	}
	
	@Override
	public List<CreateBlog> viewallblogbyauthor(String author){
		return cr.findByAuthorOrderByAuthor(author);
	}

	

	@Override
	public void addCommentToPost(int Id, comment comment) {
		 CreateBlog post = cr.findById(Id).orElse(null);
	        if (post != null) {
	            List<comment> comments = post.getComments();
	            comments.add(comment);
	            comment.setBlog(post);
	            post.setComments(comments);
	            cr.save(post);
	        }
	}
	
	@Override 
	public CreateBlog getBlogWithComments(int id) {
		CreateBlog blog = cr.findById(id).orElse(null);

        if (blog != null) {
            List<comment> comments = cor.findByblogId(id);
            blog.setComments(comments);
        }

        return blog;
	}

	@Override
	public String deleteuserpost(int id) {
		 Optional<CreateBlog> obj = cr.findById(id);
	        String msg = null;

	        if (obj.isPresent()) {
	            CreateBlog blog = obj.get();
	            cr.delete(blog);
	            msg = "Post Deleted Successfully";
	        } else {
	            msg = "Post Not Found";
	        }

	        return msg;
	}
	
	

}
