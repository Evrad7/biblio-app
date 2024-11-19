package com.iuc.ms2d4.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuc.ms2d4.entities.Auteur;
import com.iuc.ms2d4.services.AuteurService;



@RestController
@CrossOrigin("*")
@RequestMapping("/auteur")
public class AuteurController {

	 private final AuteurService auteurService;

	    public AuteurController(AuteurService auteurService) {
	        this.auteurService = auteurService;
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Auteur>> getAllAuteurs () {
	        List<Auteur> auteurList = auteurService.getAuteurList();
	        return new ResponseEntity<>(auteurList, HttpStatus.OK);
	    }

	    @GetMapping("/find/{id}")
	    public ResponseEntity<Auteur> getAuteurById (@PathVariable("id") Long auteurId) {
	        Auteur auteur = auteurService.getAuteurById(auteurId);
	        return new ResponseEntity<>(auteur, HttpStatus.OK);
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Auteur> addAuteur (@RequestBody Auteur auteur) {
	        Auteur newAuteur = auteurService.saveAuteur(auteur);
	        return new ResponseEntity<>(newAuteur, HttpStatus.OK);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Auteur> updateAuteur (@PathVariable("id") Long auteurId, @RequestBody Auteur auteur)  {
	        Auteur updateAuteur = auteurService.updateAuteur(auteurId, auteur);
	        return new ResponseEntity<>(updateAuteur, HttpStatus.OK);
	    }

	    @Transactional
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteAuteur (@PathVariable("id") Long auteurId)  {
	        auteurService.deleteAuteurById(auteurId);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
