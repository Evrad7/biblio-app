package com.iuc.ms2d4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.iuc.ms2d4.entities.Livre;
import com.iuc.ms2d4.repositories.LivreRepository;


@Service
public class LivreService {

     private LivreRepository livreRepository;

    public LivreService(LivreRepository livreRepository) {
        this.livreRepository = livreRepository;
    }


    public List<Livre> getLivreList() {
        return livreRepository.findAll();
    }


    public Livre getLivreById(Long livreId) {
        Optional<Livre> livre = livreRepository.findById(livreId);
        livre.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
        return livre.get();
    }


    public Livre saveLivre(Livre livre) {
        return livreRepository.save(livre);
    }

 
    public Livre updateLivre(Long isbn, Livre livre) {
     	Optional<Livre> optionalLivre =livreRepository.findById(isbn);
    	optionalLivre.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
    	Livre l=optionalLivre.get();
    	l.setIsbn(isbn);
    	l.setTitre(livre.getTitre());
    	l.setAuteur(livre.getAuteur());
    	return livreRepository.save(l);
    }


    public void deleteLivreById(Long livreId) {
        livreRepository.deleteById(livreId);
    }


}
