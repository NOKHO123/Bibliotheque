package com.example.bibliotheque.repository;

import com.example.bibliotheque.model.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivreRepository extends JpaRepository<Livre, Long> {
    
    // Renvoie tous les livres disponibles
    List<Livre> findByDisponibleTrue();
}
