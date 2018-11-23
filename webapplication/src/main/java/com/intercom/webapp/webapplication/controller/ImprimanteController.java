package com.intercom.webapp.webapplication.controller;

import com.intercom.webapp.webapplication.Entities.Imprimante;
import com.intercom.webapp.webapplication.business.EquipBusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/Imprimantes")
@CrossOrigin(origins = "*")
public class ImprimanteController {
    private final EquipBusiness equipBusiness;

    @Autowired
    public ImprimanteController(EquipBusiness equipBusiness) {
        this.equipBusiness = equipBusiness;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Imprimante> findAllImprimante() {
        return equipBusiness.findImpr();
    }

}
