package com.iuc.ms2d4.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Auteur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable = false)
	private String nom;

	private String prenom;
	
	
	@OneToMany(mappedBy = "auteur")
	@JsonIgnore
	private List<Livre> livres;
	
	

	public Auteur() {
		super();
	}



	public Auteur(long id, String nom, String prenom, List<Livre> livres) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.livres = livres;
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



	public List<Livre> getLivres() {
		return livres;
	}



	public void setLivres(List<Livre> livres) {
		this.livres = livres;
	}

	
	
	
	
	
}
