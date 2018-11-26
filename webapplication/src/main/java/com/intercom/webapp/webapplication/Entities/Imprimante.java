package com.intercom.webapp.webapplication.Entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("Imprimante")
public class Imprimante extends Equip {
    private String cartouche;

    public Imprimante() {
    }

    public Imprimante(String numserie, String marque, Boolean deffectueux, Date datemiseservice, Date fingarantie, Utilisateurs utilisateur, String cartouche) {
        super(numserie, marque, deffectueux, datemiseservice, fingarantie, utilisateur);
        this.cartouche = cartouche;
    }

    public String getCartouche() {
        return cartouche;
    }

    public void setCartouche(String cartouche) {
        this.cartouche = cartouche;
    }


}
