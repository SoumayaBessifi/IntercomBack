package com.intercom.webapp.webapplication.Entities;

import com.intercom.webapp.webapplication.User;

import javax.persistence.*;

public class Reclamation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idReclamation;
    private String message;


    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

}
