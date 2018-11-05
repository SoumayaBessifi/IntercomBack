package com.intercom.webapp.webapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class RegisterController {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/register")
    public User registerUser(@RequestBody User user) {
		
		/*if(userService.isUserPresent(user.getId())) {
			
         return userRepository.getOne(user.getId());
		}*/
		user.setPassword(userService.encodePassword(user.getPassword()));
		return userRepository.save(user);
	}
}
