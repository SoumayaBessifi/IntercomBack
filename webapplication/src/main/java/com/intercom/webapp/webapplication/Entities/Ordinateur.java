package com.intercom.webapp.webapplication.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;
@Entity
@DiscriminatorValue("Ordinateur")
public class Ordinateur extends Equip {

    private String memoire;
    private String processeur;
    private Boolean ecran;
    private Integer nbrecran;
    private Boolean UC;
    private Boolean clavier;
    private Boolean souris;
    private String type;
    private String sysexp;


    public Ordinateur() {
    }

    public Ordinateur(String numserie, String marque,
                      Boolean deffectueux, Date datemiseservice, Date fingarantie,
                      Utilisateurs utilisateur, String memoire, String processeur,
                      Boolean ecran, Integer nbrecran, Boolean UC, Boolean clavier, Boolean souris, String type, String sysexp) {
        super(numserie, marque, deffectueux, datemiseservice, fingarantie, utilisateur);
        this.memoire = memoire;
        this.processeur = processeur;
        this.ecran = ecran;
        this.nbrecran = nbrecran;
        this.UC = UC;
        this.clavier = clavier;
        this.souris = souris;
        this.type = type;
        this.sysexp = sysexp;
    }

    public String getMemoire() {
        return memoire;
    }

    public void setMemoire(String memoire) {
        this.memoire = memoire;
    }

    public String getProcesseur() {
        return processeur;
    }

    public void setProcesseur(String processeur) {
        this.processeur = processeur;
    }


    public Boolean getEcran() {
        return ecran;
    }

    public void setEcran(Boolean ecran) {
        this.ecran = ecran;
    }

    public Integer getNbrecran() {
        return nbrecran;
    }

    public void setNbrecran(Integer nbrecran) {
        this.nbrecran = nbrecran;
    }

    public Boolean getUC() {
        return UC;
    }

    public void setUC(Boolean UC) {
        this.UC = UC;
    }

    public Boolean getClavier() {
        return clavier;
    }

    public void setClavier(Boolean clavier) {
        this.clavier = clavier;
    }

    public Boolean getSouris() {
        return souris;
    }

    public void setSouris(Boolean souris) {
        this.souris = souris;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSysexp() {
        return sysexp;
    }

    public void setSysexp(String sysexp) {
        this.sysexp = sysexp;
    }
}
