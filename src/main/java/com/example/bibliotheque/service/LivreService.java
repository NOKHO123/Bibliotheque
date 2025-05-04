package com.example.bibliotheque.service;

import com.example.bibliotheque.model.Livre;
import com.example.bibliotheque.repository.LivreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivreService {

    @Autowired
    private LivreRepository livreRepository;

    public List<Livre> getAllLivres() {
        return livreRepository.findAll();
    }

    public Livre getLivreById(Long id) {
        Optional<Livre> livreOpt = livreRepository.findById(id);
        return livreOpt.orElse(null);
    }

    public List<Livre> getLivresDisponibles() {
        return livreRepository.findByDisponibleTrue();
    }

    public Livre ajouterLivre(Livre livre) {
        return livreRepository.save(livre);
    }

    public Livre modifierLivre(Long id, Livre updatedLivre) {
        return livreRepository.findById(id).map(livre -> {
            livre.setTitre(updatedLivre.getTitre());
            livre.setAuteur(updatedLivre.getAuteur());
            livre.setDisponible(updatedLivre.isDisponible());
            return livreRepository.save(livre);
        }).orElse(null);
    }

    public void supprimerLivre(Long id) {
        livreRepository.deleteById(id);
    }

    public void setDisponibiliteLivre(Long id, boolean disponible) {
        livreRepository.findById(id).ifPresent(livre -> {
            livre.setDisponible(disponible);
            livreRepository.save(livre);
        });
    }
}
