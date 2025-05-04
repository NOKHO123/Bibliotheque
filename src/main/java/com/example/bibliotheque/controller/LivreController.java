package com.example.bibliotheque.controller;

import com.example.bibliotheque.model.Livre;
import com.example.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livres")
public class LivreController {

    @Autowired
    private LivreService livreService;

    // GET /livres
    @GetMapping
    public List<Livre> getAllLivres() {
        return livreService.getAllLivres();
    }

    // GET /livres/{id}
    @GetMapping("/{id}")
    public Livre getLivreById(@PathVariable Long id) {
        return livreService.getLivreById(id);
    }

    // GET /livres/disponibles
    @GetMapping("/disponibles")
    public List<Livre> getLivresDisponibles() {
        return livreService.getLivresDisponibles();
    }
}
