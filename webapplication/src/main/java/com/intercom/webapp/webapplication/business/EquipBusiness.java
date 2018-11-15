package com.intercom.webapp.webapplication.business;

import com.intercom.webapp.webapplication.Entities.Equip;

import java.util.List;
//import com.intercom.webapp.webapplication.Entities.Ordinateur;

public interface EquipBusiness {
    Equip addEquip(Equip e);

    List<Equip> findAll();
/*Ordinateur addOrdinateur(Equip e, String memoire, String disqueDur, String cartegraphique,
                         String ecran, Integer nbrecran, String clavier, String souris, String sysexp);*/
}
