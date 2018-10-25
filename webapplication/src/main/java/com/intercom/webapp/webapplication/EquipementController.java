package com.intercom.webapp.webapplication;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.mapping.Index;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller   
@RequestMapping(path="/demo")
public class EquipementController {
	@Autowired
	private EquipementRepository equipementRepository;
	
	//Ajouter un equipement avec une méthode GET
	//URL :localhost:8080/demo/add?model=VAL&numSerie=VAL&type=VAL&id_util=VAL&associe=VALBOOL
	//Example : http://localhost:8080/demo/add?model=X6531&numSerie=12yt54x&type=boot&id_util=1&associe=true
	@RequestMapping(value="/add",method=RequestMethod.GET) // Map ONLY GET Requests
	public @ResponseBody Iterable<Equipement> addNewEquipement (@RequestParam String model
			, @RequestParam String numSerie
			, @RequestParam String type
			, @RequestParam int id_util
			, @RequestParam Boolean associe) {
		// @ResponseBody means the returned String is the response, not a view name
		// @RequestParam means it is a parameter from the GET or POST request

		Equipement n = new Equipement();
		n.setModel(model);
		n.setNumSerie(numSerie);
		n.setType(type);
		n.setId_util(id_util);
		n.setAssocie(associe);
		equipementRepository.save(n);
		return equipementRepository.findAll();
	}
   //Tout les équipements 
	//URL : localhost:8080/demo/all
	//Pas d'exemple
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Equipement> getAllEquipement() {
		// This returns a JSON or XML with the users
		return equipementRepository.findAll();
	}
	//Update un equipement , si n'existe pas , l'ajouter
	//URL :localhost:8080/demo/update?id=ID&model=NEWVAL&numSerie=NEWVAL&type=NEWVAL&id_util=NEWVAL&associe=NEWVAL
	//Example : http://localhost:8080/demo/update?id=1&model=X6531&numSerie=12yt54x&type=boot&id_util=1&associe=false
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public @ResponseBody Iterable<Equipement> updateEquipement(@RequestParam int id,
			@RequestParam String model
			, @RequestParam String numSerie
			, @RequestParam String type
			, @RequestParam int id_util
			, @RequestParam Boolean associe){
		Equipement equi=equipementRepository.findById(id).orElse(new Equipement());
		equi.setId(id);
		equi.setModel(model);
		equi.setNumSerie(numSerie);
		equi.setType(type);
		equi.setId_util(id_util);
		equi.setAssocie(associe);
		
		equipementRepository.save(equi);
		return equipementRepository.findAll();
	}
	//Supprimer un equipement si existe pas => Page erreur pas de message personnalisé
	//URL : http://localhost:8080/demo/delete?id=ID
	//example : http://localhost:8080/demo/delete?id=1
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public @ResponseBody Iterable<Equipement> deleteEquipement(@RequestParam int id){
		equipementRepository.deleteById(id);
		return equipementRepository.findAll();
	}
	
	//Code demonstration avec JSP
     //Liste des equipements URL : localhost:8080/demo/all-equipement => Interface Graphique
	/*@GetMapping(path="/all-equipement")
	public String allEquipement(HttpServletRequest request){
		request.setAttribute("equipements", equipementRepository.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	//Ajouter equipement URL : localhost:8080/demo/new-equipement => Interface Graphique
	@GetMapping(path="/new-equipement")
	public String newEquipement(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "index";
	}
	//Sauvegarder equipement URL : localhost:8080/demo/save-equipement => Interface Graphique
		@PostMapping(path="/save-equipement")
	public String saveEquipement(@ModelAttribute Equipement equipement, BindingResult bindingResult, HttpServletRequest request){
		
		equipementRepository.save(equipement);
		request.setAttribute("equipements", equipementRepository.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}
	//Update equipement localhost:8080/demo/update-equipement => Interface Graphique
	@GetMapping(path="/update-equipement")
	public String updateEquipement(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("equipements", equipementRepository.findById(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "index";
	}
	//Supprimer equipement : localhost:8080/demo/delete-equipement => Interface Graphique
	@GetMapping(path="/delete-equipement")
	public String deleteEquipement(@RequestParam int id, HttpServletRequest request){
		equipementRepository.deleteById(id);
		request.setAttribute("equipements", equipementRepository.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "index";
	}*/
	
}
