package com.intercom.webapp.webapplication.business;

import com.intercom.webapp.webapplication.Entities.Equip;
//import com.intercom.webapp.webapplication.Entities.Ordinateur;
import com.intercom.webapp.webapplication.repository.EquipReposirtory;
import com.intercom.webapp.webapplication.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipBusinessImpl implements EquipBusiness {
    private final UserRepository userRepository;
    private final EquipReposirtory equipReposirtory;

    public EquipBusinessImpl(UserRepository userRepository, EquipReposirtory equipReposirtory) {
        this.userRepository = userRepository;
        this.equipReposirtory = equipReposirtory;
    }

    @Override
    public Equip addEquip(Equip e) {
        return this.equipReposirtory.save(e);
    }

    @Override
    public List<Equip> findAll() {
        return equipReposirtory.findAll();
    }




    /*@Override
    public Ordinateur addOrdinateur(Equip e, String memoire, String disqueDur, String cartegraphique, String ecran, Integer nbrecran, String clavier, String souris, String sysexp) {
        this.equipReposirtory.save(e);
        Equip ordinateur=new Ordinateur();

        return null;
    }*/
}
