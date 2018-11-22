package com.intercom.webapp.webapplication.Entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_EQUIPEMENT", discriminatorType = DiscriminatorType.STRING, length = 10)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type",
        visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Ordinateur.class, name = "Ordinateur"),
        @JsonSubTypes.Type(value = Imprimante.class, name = "Imprimante"),
        @JsonSubTypes.Type(value = Routeur.class, name = "Routeur"),
        @JsonSubTypes.Type(value = Serveur.class, name = "Serveur"),
})
public  class Equip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEquip;
    private String numserie;
    private String marque;
    private Boolean deffectueux; //actif ou non
    private Date datemiseservice;
    private Date fingarantie;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Utilisateurs utilisateur;

    public Equip() {
    }

    public Equip(String numserie, String marque,
                 Boolean deffectueux, Date datemiseservice, Date fingarantie, Utilisateurs utilisateur) {
        this.numserie = numserie;
        this.marque = marque;
        this.deffectueux = deffectueux;
        this.datemiseservice = datemiseservice;
        this.fingarantie = fingarantie;
        this.utilisateur = utilisateur;
    }

    public Integer getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(Integer idEquip) {
        this.idEquip = idEquip;
    }

    public String getNumserie() {
        return numserie;
    }

    public void setNumserie(String numserie) {
        this.numserie = numserie;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Boolean getDeffectueux() {
        return deffectueux;
    }

    public void setDeffectueux(Boolean deffectueux) {
        this.deffectueux = deffectueux;
    }

    public Date getDatemiseservice() {
        return datemiseservice;
    }

    public void setDatemiseservice(Date datemiseservice) {
        this.datemiseservice = datemiseservice;
    }

    public Date getFingarantie() {
        return fingarantie;
    }

    public void setFingarantie(Date fingarantie) {
        this.fingarantie = fingarantie;
    }

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }
}
