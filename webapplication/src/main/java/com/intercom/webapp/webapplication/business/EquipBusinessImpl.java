package com.intercom.webapp.webapplication.business;

import com.intercom.webapp.webapplication.Entities.*;
//import com.intercom.webapp.webapplication.Entities.Ordinateur;
import com.intercom.webapp.webapplication.repository.EquipReposirtory;
import com.intercom.webapp.webapplication.UserRepository;
import com.intercom.webapp.webapplication.repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EquipBusinessImpl implements EquipBusiness {
    private final UserRepository userRepository;
    private final EquipReposirtory equipReposirtory;
    private final UtilisateurRepository utilisateurRepository;

    @Autowired
    public EquipBusinessImpl(UserRepository userRepository, EquipReposirtory equipReposirtory, UtilisateurRepository utilisateurRepository) {
        this.userRepository = userRepository;
        this.equipReposirtory = equipReposirtory;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Equip addEquip(Equip e) {
        e.setDatemiseservice(new Date());
        e.setDeffectueux(false);
        return this.equipReposirtory.save(e);
    }

    @Override
    public List<Imprimante> findImpr() {
        return this.equipReposirtory.findImpr();
    }

    @Override
    public List<Serveur> findServ() {
        return this.equipReposirtory.findServeur();
    }

    @Override
    public List<Routeur> findRouteur() {
        return this.equipReposirtory.findRouteur();
    }

    @Override
    public Equip findById(Integer id) {
        return equipReposirtory.findById(id).get();
    }

    @Override
    public void removeEquip(Integer id) {
        equipReposirtory.deleteById(id);
    }

    @Override
    public Equip updateEquip(Equip equip) {
        return equipReposirtory.save(equip);
    }

    @Override
    public Equip patchEquip(Integer idUt, Integer idE,
                            Boolean deffectueux, String cartouche,
                            String memoire, String processeur,
                            Boolean ecran, Integer nbrecran, Boolean UC,
                            Boolean clavier, Boolean souris, String type, String sysexp) {
        Optional<Equip> equip = equipReposirtory.findById(idE);
        if (equip.isPresent()) {
            Optional<Utilisateurs> u = utilisateurRepository.findById(idUt);
            if (u.isPresent()) {
                if (equip.get() instanceof Ordinateur) {
                    Ordinateur c = (Ordinateur) equip.get();
                    c.setUtilisateur(u.get());
                    c.setProcesseur(processeur);
                    c.setClavier(clavier);
                    c.setType(type);
                    c.setEcran(ecran);
                    c.setUC(UC);
                    c.setMemoire(memoire);
                    c.setDeffectueux(deffectueux);
                    c.setNbrecran(nbrecran);
                    c.setSouris(souris);
                    c.setSysexp(sysexp);
                    return c;

                } else if (equip.get() instanceof Routeur) {
                    Routeur r = (Routeur) equip.get();
                    r.setDeffectueux(deffectueux);
                    r.setUtilisateur(u.get());
                    return r;

                } else if (equip.get() instanceof Serveur) {
                    Serveur s = (Serveur) equip.get();
                    s.setDeffectueux(deffectueux);
                    s.setUtilisateur(u.get());
                    return s;
                } else {
                    Imprimante i = (Imprimante) equip.get();
                    i.setCartouche(cartouche);
                    i.setUtilisateur(u.get());
                    return i;
                }
            } else {
                throw new RuntimeException("User not found");
            }
        } else {
            throw new RuntimeException("Equip not found");
        }
    }

    @Override
    public List<Ordinateur> findOrdi() {
        return equipReposirtory.findOrdi();
    }
}
