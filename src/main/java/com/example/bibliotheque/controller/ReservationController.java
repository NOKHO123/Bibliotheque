package com.example.bibliotheque.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotheque.service.ReservationService;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // GET /reservations/{id}
    @GetMapping("/{id}")
    public Object getReservationById(@PathVariable Long id) {
        return reservationService.getReservationById(id);
    }

    // POST /reservations
    @PostMapping
    public String reserverLivre(@RequestParam Long livreId,
                                 @RequestParam Long userId,
                                 @RequestParam String dateDebut,
                                 @RequestParam String dateFin) {

        // Appelle le client SOAP via le service
        boolean success = ReservationService.reserverLivreViaSoap(livreId, userId,
                LocalDate.parse(dateDebut), LocalDate.parse(dateFin));

        return success ? "Réservation effectuée avec succès." : "Échec de la réservation.";
    }
}
