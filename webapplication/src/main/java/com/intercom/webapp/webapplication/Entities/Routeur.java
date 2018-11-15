package com.intercom.webapp.webapplication.Entities;

import com.intercom.webapp.webapplication.User;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Routeur")
public class Routeur extends Equip {
    public Routeur() {
    }

    public Routeur(String numserie, String marque, String designation, Boolean deffectueux, LocalDate datemiseservice, LocalDate fingarantie, Utilisateurs utilisateur) {
        super(numserie, marque, designation, deffectueux, datemiseservice, fingarantie, utilisateur);
    }
}
