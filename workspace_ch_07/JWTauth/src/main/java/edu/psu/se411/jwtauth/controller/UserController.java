package edu.psu.se411.jwtauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.psu.se411.jwtauth.model.Users;
import edu.psu.se411.jwtauth.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		userService.register(user);
		user.setPassword("");
		return user;
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		return userService.verify(user);
	}
	
}
