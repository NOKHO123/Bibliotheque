package com.example.bibliotheque.service;

import com.example.bibliotheque.model.Livre;
import com.example.bibliotheque.model.Reservation;
import com.example.bibliotheque.model.Reservation.StatutReservation;
import com.example.bibliotheque.repository.LivreRepository;
import com.example.bibliotheque.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private static ReservationRepository reservationRepository;

    @Autowired
    private static LivreRepository livreRepository;

    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public static boolean reserverLivreViaSoap(Long livreId, Long userId, LocalDate dateDebut, LocalDate dateFin) {
        Optional<Livre> livreOpt = livreRepository.findById(livreId);

        if (livreOpt.isEmpty() || !livreOpt.get().isDisponible()) {
            return false;
        }

        // Appel au client SOAP pour effectuer la réservation
        boolean result = ReservationService.reserverLivreViaSoap(livreId, userId, dateDebut, dateFin);

        if (result) {
            // Enregistre localement si réussite SOAP
            Livre livre = livreOpt.get();
            livre.setDisponible(false);
            livreRepository.save(livre);

            Reservation reservation = new Reservation(livre, userId, dateDebut, dateFin, StatutReservation.CONFIRMEE);
            reservationRepository.save(reservation);
            return true;
        }

        return false;
    }

    public void preterLivre(Long livreId, Long userId) {
        // logique à définir selon règles métier
    }

    public void retournerLivre(Long livreId, Long userId) {
        livreRepository.findById(livreId).ifPresent(livre -> {
            livre.setDisponible(true);
            livreRepository.save(livre);
        });
    }
}
