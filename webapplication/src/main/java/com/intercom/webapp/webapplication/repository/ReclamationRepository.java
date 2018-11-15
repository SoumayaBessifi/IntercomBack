package com.intercom.webapp.webapplication.repository;

import com.intercom.webapp.webapplication.Entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ReclamationRepository extends JpaRepository<Reclamation, Integer> {

    //Equipement selectEquipByUser(Integer idUser);
}
