package com.example.entities;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author BAHIJE
 * @date 29 avr. 2019 12:53:54
 */
@Entity
public class Contact implements Serializable{
	
	@Id @GeneratedValue
	private long id;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date datedenaissance;
	private String photo;
	private String email;
	private long tel;
	
	public Contact(String nom, String prenom, Date datedenaissance, String photo, String email, long tel) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.datedenaissance = datedenaissance;
		this.photo = photo;
		this.email = email;
		this.tel = tel;
	}

	public Contact() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Date getDatedenaissance() {
		return datedenaissance;
	}

	public void setDatedenaissance(Date datedenaissance) {
		this.datedenaissance = datedenaissance;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTel() {
		return tel;
	}

	public void setTel(long tel) {
		this.tel = tel;
	}

	
}
