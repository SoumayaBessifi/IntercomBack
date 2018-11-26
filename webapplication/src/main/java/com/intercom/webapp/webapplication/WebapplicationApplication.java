package com.intercom.webapp.webapplication;

import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class WebapplicationApplication implements CommandLineRunner{

	@Autowired
	private EquipementRepository equipementRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	public static void main(String[] args) {
		SpringApplication.run(WebapplicationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// Utilisateurs ut = new Utilisateurs("toto", "titi", 1, "toto@titi.com", "bobo", "info");

        User newAdmin = new User("admin", "123456", "Hole");
		  userService.createAdmin(newAdmin); 
		//int id, String model, String numSerie, String type, int id_util, Boolean associe
		equipementRepository.save(new Equipement(1,"Xz45sb","1Hjk25","PC",1,true));
		equipementRepository.save(new Equipement(2,"Xz45sb","1Hjk25","PC",1,true));
		equipementRepository.save(new Equipement(3,"Xz45sb","1Hjk25","PC",1,true));
		//int id,String username, String password, name
		
		
		
		
	}
}
