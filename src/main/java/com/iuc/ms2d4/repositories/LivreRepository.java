package com.iuc.ms2d4.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iuc.ms2d4.entities.Livre;

public interface LivreRepository extends JpaRepository<Livre, Long> {

}
