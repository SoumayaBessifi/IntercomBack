package com.intercom.webapp.webapplication.Entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("Routeur")
public class Routeur extends Equip {
    public Routeur() {
    }

    public Routeur(String numserie, String marque, Boolean deffectueux, Date datemiseservice, Date fingarantie, Utilisateurs utilisateur) {
        super(numserie, marque, deffectueux, datemiseservice, fingarantie, utilisateur);
    }
}
