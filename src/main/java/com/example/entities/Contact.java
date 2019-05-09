package com.example.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author BAHIJE
 * @date 29 avr. 2019 12:53:54
 * @see 07/05/2019
 */
@Entity
public class Contact implements Serializable{
	
	/**
	 * Contact Entity
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	private long id;
	@NotNull
	@Size(min=2, max=70, message="{Size.contact.nom}")
	private String nom;
	@NotNull
	@Size(min=2, max=70, message="{Size.contact.prenom}")
	private String prenom;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date datedenaissance;
	private String photo;
	@Email
	private String email;
	@NotNull
	//@Pattern(regexp="(^$|[0-9]{10})")
	private long tel;
	
	public Contact(String nom, String prenom, Date datedenaissance, String photo, String email, long tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.datedenaissance = datedenaissance;
		this.photo = photo;
		this.email = email;
		this.tel = tel;
	}
	
	public Contact(String nom, String prenom, Date datedenaissance, String email, long tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.datedenaissance = datedenaissance;
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
