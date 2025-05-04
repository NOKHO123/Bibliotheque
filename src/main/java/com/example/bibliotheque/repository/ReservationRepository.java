package com.example.bibliotheque.repository;

import com.example.bibliotheque.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
    // Tu peux ajouter des méthodes personnalisées ici si besoin
}

