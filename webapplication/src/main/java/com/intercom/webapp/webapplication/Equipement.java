package com.intercom.webapp.webapplication;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipement {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String model;
	private String numSerie;
	private String type;
	private int id_util;
	private Boolean associe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getNumSerie() {
		return numSerie;
	}
	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId_util() {
		return id_util;
	}
	public void setId_util(int id_util) {
		this.id_util = id_util;
	}
	public Boolean getAssocie() {
		return associe;
	}
	public void setAssocie(Boolean associe) {
		this.associe = associe;
	}
	//Attribut
	public Equipement(int id, String model, String numSerie, String type, int id_util, Boolean associe) {
		super();
		this.id = id;
		this.model = model;
		this.numSerie = numSerie;
		this.type = type;
		this.id_util = id_util;
		this.associe = associe;
	}
	public Equipement()
	{
		
	}

}
