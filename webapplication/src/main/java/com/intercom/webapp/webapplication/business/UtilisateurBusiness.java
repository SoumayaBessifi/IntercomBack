package com.intercom.webapp.webapplication.business;

import com.intercom.webapp.webapplication.Entities.Utilisateurs;

import java.util.List;

public interface UtilisateurBusiness {
    Utilisateurs addUtil(Utilisateurs u);

    Utilisateurs findById(Integer id);

    void removeUtilisateurs(Integer id);

    List<Utilisateurs> findAll();

}
