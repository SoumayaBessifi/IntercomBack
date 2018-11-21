package com.intercom.webapp.webapplication.business;

import com.intercom.webapp.webapplication.Entities.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
//import com.intercom.webapp.webapplication.Entities.Ordinateur;

public interface EquipBusiness {
    Equip addEquip(Equip e);

    Equip findById(Integer id);

    void removeEquip(Integer id);

    Equip updateEquip(Equip equip);

    Equip patchEquip(Integer idUt, Integer idE,
                     Boolean deffectueux, String cartouche,
                     String memoire, String processeur,
                     Boolean ecran, Integer nbrecran, Boolean UC,
                     Boolean clavier, Boolean souris, String type,
                     String sysexp);

    List<Ordinateur> findOrdi();

    List<Imprimante> findImpr();

    List<Serveur> findServ();

    List<Routeur> findRouteur();



}
