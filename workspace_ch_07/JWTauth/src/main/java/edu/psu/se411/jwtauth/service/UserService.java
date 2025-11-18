package edu.psu.se411.jwtauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import edu.psu.se411.jwtauth.model.Users;
import edu.psu.se411.jwtauth.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	AuthenticationManager authManager;
	
	@Autowired
	JwtService jwtService;
	
	public Users register(Users user) {
		return userRepository.save(user);
	}

	public String verify(Users user) {
		Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		if(auth.isAuthenticated())
			return jwtService.generateToken(user.getUsername());
		return "Failed";
	}
}
