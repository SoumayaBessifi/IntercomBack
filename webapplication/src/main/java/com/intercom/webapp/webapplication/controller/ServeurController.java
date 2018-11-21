package com.intercom.webapp.webapplication.controller;

import com.intercom.webapp.webapplication.Entities.Serveur;
import com.intercom.webapp.webapplication.business.EquipBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Serveurs")
@CrossOrigin(origins = "*")
public class ServeurController {
    private final EquipBusiness equipBusiness;

    @Autowired
    public ServeurController(EquipBusiness equipBusiness) {
        this.equipBusiness = equipBusiness;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Serveur> findServeur() {
        return equipBusiness.findServ();
    }
}
