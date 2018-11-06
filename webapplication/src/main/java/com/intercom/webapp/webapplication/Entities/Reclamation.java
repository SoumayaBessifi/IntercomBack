package com.intercom.webapp.webapplication.Entities;

import com.intercom.webapp.webapplication.Equipement;
import com.intercom.webapp.webapplication.User;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReclamation;
    private String description;

    private Date date_creation;
    private String urgence; //haute moyenne basse

    private String etat; //en cour en attente cloturé

    private Integer idEquip;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Reclamation() {
    }

    public Reclamation(String description, String urgence, String etat, Integer idEquip, User user) {
        this.description = description;
        this.date_creation = date_creation;
        this.urgence = urgence;
        this.etat = etat;
        this.idEquip = idEquip;
        this.user = user;
    }

    public Integer getIdEquip() {
        return idEquip;
    }

    public void setIdEquip(Integer idEquip) {
        this.idEquip = idEquip;
    }

    public Integer getIdReclamation() {
        return idReclamation;
    }

    public void setIdReclamation(Integer idReclamation) {
        this.idReclamation = idReclamation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    public String getUrgence() {
        return urgence;
    }

    public void setUrgence(String urgence) {
        this.urgence = urgence;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
