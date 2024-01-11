package com.blog.controller;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.blog.entity.Admin;
import com.blog.entity.CreateBlog;
import com.blog.entity.User;
import com.blog.entity.comment;
import com.blog.model.AdminService;
import com.blog.model.CommentService;
import com.blog.model.CreateBlogService;
import com.blog.model.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService us;
	
	@Autowired
	AdminService as;
	
	@Autowired
	CreateBlogService cbs;
	
	@Autowired
	CommentService cs;
	
	@GetMapping("/")
	public String main()
	{
		return "index";
	}
	
	@PostMapping("insert")
	public ModelAndView insertaction(HttpServletRequest request) {
	    String msg = null;
	    ModelAndView mv = new ModelAndView();

	    try {
	        String name = request.getParameter("name");
	        String email = request.getParameter("email");
	        String pass = request.getParameter("pass");

	        User emp = new User();
	        emp.setName(name);
	        emp.setEmail(email);
	        emp.setPass(pass);

	       

	        msg = us.AddUser(emp);

	        mv.setViewName("login");
	        mv.addObject("message", msg);
	    } catch (Exception e) {
	        msg = "Invalid Register";
	        mv.setViewName("register");
	        mv.addObject("message", msg);
	        request.setAttribute("errorMessage", "Invalid Register. Please try again.");
	    }

	    return mv;
	}

	
																				//Create Blog
	
	@GetMapping("addBlog")
	public ModelAndView addblogdemo()
	{
		ModelAndView mv = new ModelAndView("addblog");
		return mv;
	}
	
	

	@PostMapping("insert-blog-post")
	public ModelAndView insertblog(HttpServletRequest request, @RequestParam("image") MultipartFile file) throws IOException, SQLException {
	    String msg = null;
	    ModelAndView mv = new ModelAndView();

	    try {
	        String title = request.getParameter("title");
	        String author = request.getParameter("author");
	        String content = request.getParameter("content");

	        byte[] bytes = file.getBytes();
	       Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

	        CreateBlog cb = new CreateBlog();
	        cb.setTitle(title);
	        cb.setAuthor(author);
	        cb.setContent(content);
	        cb.setImage(blob);

	        msg = cbs.Addblog(cb);
	        System.out.println(msg);
	        mv.setViewName("dashboard");
	        mv.addObject("message", msg);
	    } catch (Exception e) {
	        msg = e.getMessage();
	        System.out.println(msg.toString());
	        mv.setViewName("CreatePost");
	        mv.addObject("message", msg);
	    }
	    return mv;
	}
	
	@PostMapping("addcomment")
	public String addComment(@RequestParam int id, @RequestParam String comment,@RequestParam String name, HttpServletRequest request) {
	    // Get the name from the request parameter
		 String msg = null;
		    
		    ModelAndView mv = new ModelAndView();
		    
		    HttpSession session = request.getSession();
		    
		      mv.addObject("name", session.getAttribute("ename"));
		      
		     // int eid = (int) session.getAttribute("eid");
		      
		      try
			   {
			     String uname = request.getParameter("name");
			     
			     User emp = new User();
			     
			     
			     emp.setName(uname);
			    
			     msg = us.updateUser(emp);
			      mv.setViewName("viewblogindetail");
			      mv.addObject("message",msg);
			   } catch(Exception e) {
				   msg = e.getMessage();
				     
				     mv.setViewName("viewAllblog");
				      mv.addObject("message",msg);
			   }
		
		comment c = new comment();
     c.setName(name);
     c.setComment(comment);
     cs.AddComment(id, c);
     return "redirect:/viewblogindetail?id=" + id;
	}
	
	
	@PostMapping("login")
	public ModelAndView checklogin(HttpServletRequest request)
	{
		
		ModelAndView mv=new ModelAndView();
		
		String email = request.getParameter("email");
	    String pass = request.getParameter("pass");
	    
	    Admin admin= as.checkadminlogin(email, pass);
	    
	    User emp =  us.checklogin(email, pass);
	    if(admin!=null) {
	    	mv.setViewName("admindash");
	    }else if(emp!=null){
	    	
	      //session
	      HttpSession session = request.getSession();
	      
	      session.setAttribute("eid", emp.getId()); //eid is a session variable
	      session.setAttribute("ename", emp.getName());
	      session.setAttribute("eemail", emp.getEmail());//ename is a session variable
	      session.setAttribute("eusername", emp.getUsername());
	      session.setAttribute("econtact", emp.getContactno());
	      session.setAttribute("epass", emp.getPass());
	      session.setAttribute("image", emp.getImage());
	      
	 
	      mv.setViewName("dashboard");
	    }
	    else
	    {
	      mv.setViewName("login");
	      mv.addObject("message", "Login Failed");
	      request.setAttribute("errorMessage", "Incorrect email or password. Please try again.");

	    }
	    return mv;
	    
	}
	
	@PostMapping("update")
	  public ModelAndView updateaction(HttpServletRequest request, @RequestParam("contact") String contact,@RequestParam("image") MultipartFile file) throws IOException, SQLException
	  {
	    String msg = null;
	    
	    ModelAndView mv = new ModelAndView();
        HttpSession session = request.getSession();
	    
	    mv.addObject("id", session.getAttribute("eid"));
	    mv.addObject("name", session.getAttribute("ename"));
	    mv.addObject("username", session.getAttribute("eusername"));
	    mv.addObject("email", session.getAttribute("eemail"));
	    mv.addObject("contact", session.getAttribute("econtact"));
	    mv.addObject("pass", session.getAttribute("epass"));
	    mv.addObject("image", session.getAttribute("image"));
	    
	    int id = (int) session.getAttribute("eid");
	    try
		   {
		     String name = request.getParameter("name");
		     String username = request.getParameter("username");
		     String contact1 = request.getParameter("contact");
		     String email = request.getParameter("email");
		     String pass = request.getParameter("pass");
		     	     
		     byte[] bytes = file.getBytes();
		     
		     User emp = new User();
		      emp.setId(id);
		      emp.setName(name);
		      emp.setUsername(username);
		      emp.setContactno(contact1);
		      emp.setEmail(email);
		      emp.setPass(pass);
		      
		      
		      if (bytes.length > 0) {
		            Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);
		            emp.setImage(blob);
		        }
	
		      msg = us.updateUser(emp);
		      mv.setViewName("dashboard");
		      mv.addObject("message",msg);
		      
		   // In your controller
		      if (msg.equals("Image is null")) {
		          // Set a flag or message to indicate that the image is null
		          mv.addObject("imgmsg", "Image is null");
		      }

		     
		   }
		   catch(Exception e)
		   {
		     msg = e.getMessage();
		     
		     mv.setViewName("login");
		      mv.addObject("message",msg);
		   }
	    return mv;
	  }
	
	 @GetMapping("loghome")
	  public ModelAndView loghome(HttpServletRequest request)
	  {
		HttpSession session = request.getSession();
		int eid = (int)session.getAttribute("id"); //eid is a session variable
		String ename = (String)session.getAttribute("name"); //ename is a session variable
		
	    ModelAndView mv = new ModelAndView();
	    mv.setViewName("loghome");
	    
	    mv.addObject("eid", eid);
	    mv.addObject("ename", ename);
	    return mv;
	  }
	 
	 @GetMapping("updateprofile")
	  public ModelAndView updateuser(HttpServletRequest request)
	  {
	    ModelAndView mv = new ModelAndView();
	    
	    HttpSession session = request.getSession();
	    
	    mv.setViewName("userprofile");
	    
	    mv.addObject("eid", session.getAttribute("eid"));
	    mv.addObject("ename", session.getAttribute("ename"));
	    mv.addObject("eusername", session.getAttribute("eusername"));
	    mv.addObject("eemail", session.getAttribute("eemail"));
	    mv.addObject("econtact", session.getAttribute("econtact"));
	    mv.addObject("epass", session.getAttribute("epass"));
	    mv.addObject("image", session.getAttribute("image"));
	    
	    int id = (int) session.getAttribute("eid");
	    
	    User emp = us.viewuserbyid(id);
	    
	    mv.addObject("emp", emp);
	    
	    return mv;
	  }
	 
	 @GetMapping("displayprofileimage")
	 public ResponseEntity<byte[]> displayprofileimage(@RequestParam("id") int id) throws IOException, SQLException {
	     User user = us.viewuserbyid(id);
	     
	     if (user != null && user.getImage() != null) {
	         byte[] imageBytes = user.getImage().getBytes(1, (int) user.getImage().length());
	         return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	     } else {
	         // If no user or no image, return a default image or handle it as needed
	         return ResponseEntity.notFound().build();
	     }
	 }

	 
	 @GetMapping("viewalluser")
		public ModelAndView viewemps()
		{
			List<User>userlist=as.viewalluser();
			
			ModelAndView mv=new ModelAndView("viewalluser");
			mv.addObject("userdata", userlist);
			return mv;
			
		}
	 
	 @GetMapping("viewallblogsadmin")
	 public ModelAndView viewblogsadmin() {
		 List<CreateBlog> cblist=cbs.viewAllBlog();
		 ModelAndView mv=new ModelAndView("viewallpostadmin");
		 mv.addObject("blogadmin",cblist);
		 return mv;
	 }
	 
	 @GetMapping("viewAllblog")
	 public ModelAndView viewblog(){
		 ModelAndView mv=new ModelAndView();
			mv.setViewName("viewAllblog");
		 List<CreateBlog> bloglist=cbs.viewAllBlog();
		// ModelAndView mv=new ModelAndView("viewAllblog");
		 //System.out.println(bloglist);
		 mv.addObject("blogs",bloglist);
		 return mv;
		 
	 }
	 
	 @GetMapping("viewblogindetail")
	 public ModelAndView viewblogindetail(@RequestParam("id") int id) {
		 CreateBlog cb=as.viewallbyblogid(id);
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("viewblogindetail");
		 mv.addObject("blog",cb);
		 return mv;
	 }
	 
	 @GetMapping("viewallcomments/{blog_id}")
	 public ModelAndView viewallcomments(@RequestParam("id")int id) {
		 ModelAndView mv = new ModelAndView();
		    List<comment> comments = cs.allcomment(id); // Replace with your actual service method to get comments.
		    mv.addObject("comments", comments);
		    mv.setViewName("viewAllComments"); // Create a view to display all comments.
		    return mv;
		 
		 
	 }
	 
	 @GetMapping("displayuserimage")
	 public ResponseEntity<byte[]> displayuserimage(@RequestParam("id")int id) throws IOException, SQLException{
		 User img = us.viewuserbyid(id);
		 byte[] imagebytes=null;
		 imagebytes = img.getImage().getBytes(1,(int) img.getImage().length());
		 return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagebytes);
	 }
	 
	 @GetMapping("displayproimage")
	 public ResponseEntity<byte[]> displayprodimagedemo(@RequestParam("id") int id) throws IOException, SQLException {
	     CreateBlog post =  cbs.viewallblogsbyid(id);
	     byte [] imageBytes = null;
	      imageBytes = post.getImage().getBytes(1,(int) post.getImage().length());

	     return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
	 }
	 
	 @GetMapping("viewalluserdetails")
	 public ModelAndView viewempdemo(@RequestParam("id") int id)
	   {
	     User user = as.viewallbyid(id);
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("viewalluserdetails");
	     mv.addObject("user", user);
	     return mv;
	   }
	 
	 @GetMapping("/viewpostindetail")
	 public ModelAndView viewpostdetail(@RequestParam("id") int id) {
	     // Retrieve the blog and comment data by ID
	     CreateBlog cb = cbs.getBlogWithComments(id);
	     //comment comments = as.viewallcommentbyid(id); // Assuming you have a list of comments

	     // Create a ModelAndView and pass both the blog and comments to the view
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("viewallpostdetails");
	     mv.addObject("blog", cb); // Add the blog to the model
	     //mv.addObject("comment", comments); // Add the comments to the model

	     return mv;
	 }

		 /*		 CreateBlog cb=as.viewallbyblogid(id);
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("viewallpostdetails");
		 mv.addObject("blog",cb);
		 return mv;*/
	 
	 @GetMapping("viewblogwithcommentinuser")
	 public ModelAndView viewblogwithcommentinuser(@RequestParam("id") int id) {
		// Retrieve the blog and comment data by ID
	     CreateBlog cb = cbs.getBlogWithComments(id);
	     //comment comments = as.viewallcommentbyid(id); // Assuming you have a list of comments

	     // Create a ModelAndView and pass both the blog and comments to the view
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("viewblogindetail");
	     mv.addObject("blog", cb); // Add the blog to the model
	     //mv.addObject("comment", comments); // Add the comments to the model

	     return mv;
	 }
	 
	 
	 @GetMapping("viewallcommentsbyidadmin")
	 public ModelAndView viewallcommentbyidadmin() {
		 
		 ModelAndView mv=new ModelAndView();
		mv.setViewName("viewAllcomments");
		List<comment> userlist =as.ViewallComments();
		mv.addObject("comment", userlist);
		return mv;
		/*List<CreateBlog> cblist=cbs.viewAllBlog();
		 ModelAndView mv=new ModelAndView("viewallpostadmin");
		 mv.addObject("blogadmin",cblist);
		 return mv;*/
		}
	 
	 
	 
	 @GetMapping("viewallcommentsbyid")
	 public ModelAndView viewallcommentsbyid(@RequestParam("id") int id) {
		 comment cb=cs.viewallcomment(id);
		 ModelAndView mv=new ModelAndView();
		 mv.setViewName("viewblogindetail");
		 mv.addObject("blogadmin",cb);
		 return mv;
	 }
	 
	 @GetMapping("deleteuser/{id}")
	 public String deleteuser(@PathVariable("id") int id) {
		 as.deleteuser(id);
		 return"redirect:/viewalluser";
	 }
	 
	 @GetMapping("deletepost/{id}")
	 public String deletepost(@PathVariable("id") int id) {
		 as.deletepost(id);
		 return"redirect:/viewallblogsadmin";
	 }
	 
	 @GetMapping("deletecommentadmin/{id}")
	 public String deletecommentadmin(@PathVariable("id") int id) {
		 as.deletecommentadmin(id);
		 return"redirect:/viewallcommentsbyidadmin";
	 }
	 
	 @GetMapping("deletecomment/{id}")
	 public String deletecomment(@PathVariable("id") int id) {
		 
		 as.deletecomment(id);
		 return"redirect:/viewallpostdetails?id=" + id;
	 }
	 
	
	
}
