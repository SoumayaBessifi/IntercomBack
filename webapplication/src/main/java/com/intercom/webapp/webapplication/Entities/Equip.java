package com.intercom.webapp.webapplication.Entities;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.intercom.webapp.webapplication.User;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;

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
public abstract class Equip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idEquip;
    private String numserie;
    private String marque;
    private String designation;
    private Boolean deffectueux; //actif ou non
    private LocalDate datemiseservice;
    private LocalDate fingarantie;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Utilisateurs utilisateur;

    public Equip() {
    }

    public Equip(String numserie, String marque,
                 String designation, Boolean deffectueux, LocalDate datemiseservice, LocalDate fingarantie, Utilisateurs utilisateur) {
        this.numserie = numserie;
        this.marque = marque;
        this.designation = designation;
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

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Boolean getDeffectueux() {
        return deffectueux;
    }

    public void setDeffectueux(Boolean deffectueux) {
        this.deffectueux = deffectueux;
    }

    public LocalDate getDatemiseservice() {
        return datemiseservice;
    }

    public void setDatemiseservice(LocalDate datemiseservice) {
        this.datemiseservice = datemiseservice;
    }

    public LocalDate getFingarantie() {
        return fingarantie;
    }

    public void setFingarantie(LocalDate fingarantie) {
        this.fingarantie = fingarantie;
    }

    public Utilisateurs getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateurs utilisateur) {
        this.utilisateur = utilisateur;
    }
}
