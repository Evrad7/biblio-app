package com.iuc.ms2d4.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Livre {
	
	@Id
	private long isbn;
	
	@Column(nullable = false)
	private String titre;
		
	@ManyToOne
	private Auteur auteur;
	
	public Livre() {
		super();
	}

	public Livre(long isbn, String titre, Auteur auteur) {
		super();
		this.isbn = isbn;
		this.titre = titre;
		this.auteur = auteur;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	
	
}
