package org.demo.repo;

import java.util.List;

import org.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	public List<User> findByUserName(String userName);
}
