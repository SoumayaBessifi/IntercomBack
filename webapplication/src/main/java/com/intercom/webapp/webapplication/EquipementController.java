package com.intercom.webapp.webapplication;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.mapping.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController   
@RequestMapping(path="/gestionequip")
@CrossOrigin(origins="http://localhost:4200",allowedHeaders="*")
public class EquipementController {
	@Autowired
	private EquipementRepository equipementRepository;
	
	/*@GetMapping("/login") 
	public String showLoginForm() {
		
		return "views/loginForm";  
	}*/
	
	@GetMapping("/equipements")
	public Iterable<Equipement> getEquipement() {
		return equipementRepository.findAll();
	}

	@GetMapping("/equipement/{id}")
	public Equipement getEquipementsById(@PathVariable int id) {
		return equipementRepository.findById(id).orElse(new Equipement());
		
	}

	@DeleteMapping("/equipement/{id}")
	public boolean deleteEquip(@PathVariable int id) {
		equipementRepository.deleteById(id);
		return true;
	}

	@PutMapping("/equipement")
	public Equipement updateEquip(@RequestBody Equipement equip) {
		return equipementRepository.save(equip);
	}

	@PostMapping("/equipement")
	public Equipement addEquip(@RequestBody Equipement equip) {
		return equipementRepository.save(equip);
	}
	
	
}
