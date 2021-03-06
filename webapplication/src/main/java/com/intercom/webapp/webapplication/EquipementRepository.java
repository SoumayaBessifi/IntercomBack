package com.intercom.webapp.webapplication;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends JpaRepository<Equipement,Integer> {
	
	List<Equipement> findByUser(User user); 

}
