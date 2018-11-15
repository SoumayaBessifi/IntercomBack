package com.intercom.webapp.webapplication.controller;

import com.intercom.webapp.webapplication.business.EquipBusiness;
import com.intercom.webapp.webapplication.Entities.Equip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/Materiaux")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MaterielController {
    private final EquipBusiness equipBusiness;

    @Autowired
    public MaterielController(EquipBusiness equipBusiness) {
        this.equipBusiness = equipBusiness;
    }

    @RequestMapping(method = RequestMethod.POST)
    Equip addEquip(@RequestBody Equip equip) {
        return equipBusiness.addEquip(equip);
    }

    @GetMapping("/equipements")
    @RequestMapping(method = RequestMethod.GET)
    List<Equip> findAll() {
        return equipBusiness.findAll();
    }

}
