package com.intercom.webapp.webapplication.controller;

import com.intercom.webapp.webapplication.Entities.Utilisateurs;
import com.intercom.webapp.webapplication.business.UtilisateurBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/utilisateurs")
@CrossOrigin(origins = "*")
public class UtilisateursController {

    private final UtilisateurBusiness utilisateurBusiness;

    @Autowired
    public UtilisateursController(UtilisateurBusiness utilisateurBusiness) {
        this.utilisateurBusiness = utilisateurBusiness;
    }

    @RequestMapping(method = RequestMethod.POST)
    Utilisateurs addUtilisateur(@RequestBody Utilisateurs utilisateur) {
        return utilisateurBusiness.addUtil(utilisateur);
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Utilisateurs> findAllUtilisateurs() {
        return utilisateurBusiness.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    void removeUtilisateurs(@PathVariable Integer id) {
        utilisateurBusiness.removeUtilisateurs(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    Utilisateurs findById(@PathVariable Integer id) {
        return utilisateurBusiness.findById(id);
    }


}
