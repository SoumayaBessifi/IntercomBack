package com.intercom.webapp.webapplication.Entities;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Utilisateurs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUtilisateur;
    private String nom;
    private String prenom;
    private Integer matricule;
    private String email;
    private String mdp;
    private String departement;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Equip> listEquip;

    public Utilisateurs() {
    }

    public Utilisateurs(Utilisateurs utilisateur) {
        this.roles = utilisateur.getRoles();
        this.departement = utilisateur.getDepartement();
        this.email = utilisateur.getEmail();
        this.idUtilisateur = utilisateur.getIdUtilisateur();
        this.matricule = utilisateur.getMatricule();
        this.mdp = utilisateur.getMdp();
        this.nom = utilisateur.getNom();
        this.prenom = utilisateur.getPrenom();
    }

    /*public Utilisateurs(String nom, String prenom, Integer matricule, String email, String mdp, String departement, Role role) {
        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.email = email;
        this.mdp = mdp;
        this.departement = departement;
    }
*/
    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<Equip> getListEquip() {
        return listEquip;
    }

    public void setListEquip(List<Equip> listEquip) {
        this.listEquip = listEquip;
    }

    public Integer getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(Integer idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getMatricule() {
        return matricule;
    }

    public void setMatricule(Integer matricule) {
        this.matricule = matricule;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }
}
