package org.demo.controller;

import java.util.List;

import org.demo.model.User;
import org.demo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepo userRepo;

	@RequestMapping (value="/getUserByName", method=RequestMethod.GET, produces="text/html")
	public String getUserByName(
			@RequestParam (name="uname") String userName,
			@RequestParam (name="pwd") String key
			)
	{
		
		String isAuthenticated = "notok";
		List<User> users = userRepo.findByUserName(userName);
		for(User u : users) {
		if(userName.equals(u.getUserName()) && key.equals(u.getPassword()))
				{
			
			isAuthenticated="ok welcome";
			break;
				}
		}
		
		return isAuthenticated;
	}

	@RequestMapping (value="/getUser", method=RequestMethod.GET, produces="text/html")
	public String getUserList(
			@RequestParam (name="uid") int userId
			)
	{
		User u = userRepo.findById(userId).get();	
		String udetail = u.getUserId()+"   "+u.getUserName()+"   "+u.getPassword();
		System.out.println(udetail);
		return udetail;
	}
	
	@RequestMapping (value="/getAllUsers", method=RequestMethod.GET, produces="application/json")
	public List<User> getAllUsers()
	{
		return userRepo.findAll();
	}

}

