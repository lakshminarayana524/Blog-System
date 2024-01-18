package com.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//import java.util.Optional;
import com.blog.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u where email=?1 and pass=?2")
	public User checklogin(String email,String pass);
	
    User findByUsername(String username);

}
