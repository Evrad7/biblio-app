package com.iuc.ms2d4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.iuc.ms2d4.entities.Auteur;
import com.iuc.ms2d4.repositories.AuteurRepository;


@Service
public class AuteurService {

    private AuteurRepository auteurRepository;

   public AuteurService(AuteurRepository auteurRepository) {
       this.auteurRepository = auteurRepository;
   }


   public List<Auteur> getAuteurList() {
       return auteurRepository.findAll();
   }


   public Auteur getAuteurById(Long auteurId) {
       Optional<Auteur> auteur = auteurRepository.findById(auteurId);
       auteur.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
       return auteur.get();
   }


   public Auteur saveAuteur(Auteur auteur) {
       return auteurRepository.save(auteur);
   }


   public Auteur updateAuteur(Long id, Auteur auteur) {
    	Optional<Auteur> optionalAuteur =auteurRepository.findById(id);
   	optionalAuteur.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
   	Auteur a=optionalAuteur.get();
   	a.setId(id);
   	a.setNom(auteur.getNom());
   	a.setPrenom(auteur.getPrenom());
   	return auteurRepository.save(a);
   }


   public void deleteAuteurById(Long auteurId) {
       auteurRepository.deleteById(auteurId);
   }

}
