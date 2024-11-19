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

import com.iuc.ms2d4.entities.Vente;
import com.iuc.ms2d4.services.VenteService;



@RestController
@CrossOrigin("*")
@RequestMapping("/vente")
public class VenteController {

	 private final VenteService venteService;

	    public VenteController(VenteService venteService) {
	        this.venteService = venteService;
	    }

	    @GetMapping("/all")
	    public ResponseEntity<List<Vente>> getAllVentes () {
	        List<Vente> venteList = venteService.getVenteList();
	        return new ResponseEntity<>(venteList, HttpStatus.OK);
	    }

	    @GetMapping("/find/{id}")
	    public ResponseEntity<Vente> getVenteById (@PathVariable("id") Long venteId) {
	        Vente vente = venteService.getVenteById(venteId);
	        return new ResponseEntity<>(vente, HttpStatus.OK);
	    }

	    @PostMapping("/add")
	    public ResponseEntity<Vente> addVente (@RequestBody Vente vente) {
	        Vente newVente = venteService.saveVente(vente);
	        return new ResponseEntity<>(newVente, HttpStatus.OK);
	    }

	    @PutMapping("/update/{id}")
	    public ResponseEntity<Vente> updateVente (@PathVariable("id") Long venteId, @RequestBody Vente vente)  {
	        Vente updateVente = venteService.updateVente(venteId, vente);
	        return new ResponseEntity<>(updateVente, HttpStatus.OK);
	    }

	    @Transactional
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> deleteVente (@PathVariable("id") Long venteId)  {
	        venteService.deleteVenteById(venteId);
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
}
