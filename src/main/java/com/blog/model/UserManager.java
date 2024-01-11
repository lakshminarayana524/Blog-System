package com.blog.model;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.User;
import com.blog.repository.UserRepo;

@Service
public class UserManager implements UserService {

	@Autowired
	UserRepo ur;
	
	public String AddUser(User u) {
		 ur.save(u);
		 return "Successfully Register";
	}
	
	public User checklogin(String email,String pass) {
		return ur.checklogin(email, pass);
	}
	
	@Override
	public User viewuserbyid(int id) {
		Optional<User> obj = ur.findById(id);    
		    
	    if(obj.isPresent())
	    {
	    	User emp = obj.get();
		    return emp;
		    }
		    else
		    {
		      return null;
		    }
		    
	}
	
	public String updateUser(User u) {
		ur.save(u);
		return "Employee Updated";
	}
}

