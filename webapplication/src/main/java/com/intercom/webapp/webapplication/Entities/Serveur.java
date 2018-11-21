package com.intercom.webapp.webapplication.Entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Serveur")
public class Serveur extends Equip {
    public Serveur() {
    }

    public Serveur(String numserie, String marque, Boolean deffectueux, Date datemiseservice, Date fingarantie, Utilisateurs utilisateur) {
        super(numserie, marque, deffectueux, datemiseservice, fingarantie, utilisateur);
    }
}
