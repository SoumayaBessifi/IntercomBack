package com.intercom.webapp.webapplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipementRepository extends CrudRepository<Equipement,Integer> {

}
