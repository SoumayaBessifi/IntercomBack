package com.intercom.webapp.webapplication.repository;

import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateurs, Integer> {
}
