package com.intercom.webapp.webapplication.controller;

import com.intercom.webapp.webapplication.Entities.Ordinateur;
import com.intercom.webapp.webapplication.business.EquipBusiness;
import com.intercom.webapp.webapplication.Entities.Equip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping(path = "/Materiaux")
@CrossOrigin(origins = "*")
public class MaterielController {
    private final EquipBusiness equipBusiness;

    @Autowired
    public MaterielController(EquipBusiness equipBusiness) {
        this.equipBusiness = equipBusiness;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Equip addEquip(@RequestBody Equip equip) {
        return equipBusiness.addEquip(equip);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Ordinateur> findAllOrdinateur() {
        return equipBusiness.findOrdi();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeEquip(@PathVariable Integer id) {
        equipBusiness.removeEquip(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public Equip updateEquip(@PathVariable Integer id, @RequestBody Equip equip) {
        return equipBusiness.updateEquip(equip);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Equip findById(@PathVariable Integer id) {
        return equipBusiness.findById(id);
    }

    /*@RequestMapping(path = "/{idEquip}",method = RequestMethod.PATCH)
    Equip patchEquip(@PathVariable Integer idEquip){} */
}
