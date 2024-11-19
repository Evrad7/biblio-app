package com.iuc.ms2d4.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.iuc.ms2d4.entities.Vente;
import com.iuc.ms2d4.repositories.VenteRepository;


@Service
public class VenteService {

    private VenteRepository venteRepository;

   public VenteService(VenteRepository venteRepository) {
       this.venteRepository = venteRepository;
   }


   public List<Vente> getVenteList() {
       return venteRepository.findAll();
   }


   public Vente getVenteById(Long venteId) {
       Optional<Vente> vente = venteRepository.findById(venteId);
       vente.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
       return vente.get();
   }


   public Vente saveVente(Vente vente) {
       return venteRepository.save(vente);
   }


   public Vente updateVente(Long id, Vente vente) {
    	Optional<Vente> optionalVente =venteRepository.findById(id);
   	optionalVente.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
   	Vente v=optionalVente.get();
   	v.setId(id);
   	v.setIsbn(vente.getIsbn());
   	v.setDate(vente.getDate());
   	return venteRepository.save(v);
   }


   public void deleteVenteById(Long venteId) {
       venteRepository.deleteById(venteId);
   }

}
