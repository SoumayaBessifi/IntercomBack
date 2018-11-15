package com.intercom.webapp.webapplication.Entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("Imprimante")
public class Imprimante extends Equip {
    private String cartouche;
    private Boolean cableAlimentation;


    public Imprimante(String numserie, String marque, String designation, Boolean deffectueux, LocalDate datemiseservice, LocalDate fingarantie, Utilisateurs utilisateur, String cartouche, Boolean cableAlimentation) {
        super(numserie, marque, designation, deffectueux, datemiseservice, fingarantie, utilisateur);
        this.cartouche = cartouche;
        this.cableAlimentation = cableAlimentation;
    }

    public String getCartouche() {
        return cartouche;
    }

    public void setCartouche(String cartouche) {
        this.cartouche = cartouche;
    }

    public Boolean getCableAlimentation() {
        return cableAlimentation;
    }

    public void setCableAlimentation(Boolean cableAlimentation) {
        this.cableAlimentation = cableAlimentation;
    }
}
