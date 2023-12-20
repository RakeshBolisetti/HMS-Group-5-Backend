package com.team5.secure.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.team5.beans.Users;
import com.team5.secure.repository.UserRepository;


@RestController
@CrossOrigin  
public class MyController {
	@Autowired
	private UserRepository userRepo;
	@GetMapping("/")
	public String home() {
		return "<h1> Home Page</h1>";
	}
	@GetMapping("/user")
	public String user() {
		return "<h1> User Page</h1>";
	}
	@GetMapping( value = "/admin",produces = {"application/json","application/xml"})
	public String admin() {
		return "<h1> Admin Page</h1>";
	}
	
	@GetMapping("/update")
	@PreAuthorize("hasAuthority('admin')")
	//@PreAuthorize("hasAnyRole('admin','user')")
	public String update(Principal p) {
		
		Users user=userRepo.findByEmail(p.getName());

		return "<h1> Update Page "+p.getName()+ " and user id is "+ user.getUserId()+" </h1>";
	}
	@GetMapping("/user1")
	@PreAuthorize("hasAuthority('user')")
	public String user1(Principal p) {
		Users user=userRepo.findByEmail(p.getName());
		return "<h1> User1ex Page "+p.getName()+" and user id is "+ user.getUserId()+" </h1>";
	}
	
}
