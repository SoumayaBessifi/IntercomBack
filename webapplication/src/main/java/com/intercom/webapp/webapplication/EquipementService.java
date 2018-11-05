package com.intercom.webapp.webapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipementService {

	@Autowired
	private EquipementRepository equipementRepository;
	
	public void addEquipement(Equipement task, User user) {
		task.setUser(user);
		equipementRepository.save(task);
	}
	
	public List<Equipement>  findUserEquipements(User user){
		
		return equipementRepository.findByUser(user);
	}
}
