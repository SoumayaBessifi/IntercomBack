package com.intercom.webapp.webapplication.repository;

import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateurs, Integer> {
    Optional<Utilisateurs> findByMatricule(Integer matricule);

    Optional<Utilisateurs> findByEmail(String email);
}
