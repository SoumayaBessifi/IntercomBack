package com.intercom.webapp.webapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/myProfile")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class ProfileController {

	@Autowired
	private EquipementService equipementService;
	
	@GetMapping("/profile")
public Iterable<Equipement> showProfilePage(User user) {
		return equipementService.findUserEquipements(user);
	}
	
}
