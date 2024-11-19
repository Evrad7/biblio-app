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

import com.iuc.ms2d4.entities.Livre;
import com.iuc.ms2d4.services.LivreService;



@RestController
@CrossOrigin("*")
@RequestMapping("/livre")
public class LivreController {

    private final LivreService livreService;

    public LivreController(LivreService livreService) {
        this.livreService = livreService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Livre>> getAllLivres () {
        List<Livre> livreList = livreService.getLivreList();
        return new ResponseEntity<>(livreList, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Livre> getLivreById (@PathVariable("id") Long livreId) {
        Livre livre = livreService.getLivreById(livreId);
        return new ResponseEntity<>(livre, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Livre> addLivre (@RequestBody Livre livre) {
        Livre newLivre = livreService.saveLivre(livre);
        return new ResponseEntity<>(newLivre, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Livre> updateLivre (@PathVariable("id") Long livreId, @RequestBody Livre livre)  {
        Livre updateLivre = livreService.updateLivre(livreId, livre);
        return new ResponseEntity<>(updateLivre, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteLivre (@PathVariable("id") Long livreId)  {
        livreService.deleteLivreById(livreId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
