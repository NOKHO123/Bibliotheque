package com.example.bibliotheque.soap.endpoint;

import com.example.bibliotheque.model.Livre;
import com.example.bibliotheque.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;

@Endpoint
public class LivreSoapEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/bibliotheque/soap";

    @Autowired
    private LivreService livreService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AjouterLivreRequest")
    @ResponsePayload
    public AjouterLivreResponse ajouterLivre(@RequestPayload AjouterLivreRequest request) {
        Livre livre = new Livre(request.getTitre(), request.getAuteur());
        Livre saved = livreService.ajouterLivre(livre);

        AjouterLivreResponse response = new AjouterLivreResponse();
        response.setLivreId(saved.getId());
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "ModifierLivreRequest")
    @ResponsePayload
    public ModifierLivreResponse modifierLivre(@RequestPayload ModifierLivreRequest request) {
        Livre updated = new Livre(request.getTitre(), request.getAuteur());
        updated.setDisponible(request.getDisponible());
        Livre livre = livreService.modifierLivre(request.getLivreId(), updated);

        ModifierLivreResponse response = new ModifierLivreResponse();
        response.setSuccess(livre != null);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SupprimerLivreRequest")
    @ResponsePayload
    public SupprimerLivreResponse supprimerLivre(@RequestPayload SupprimerLivreRequest request) {
        livreService.supprimerLivre(request.getLivreId());
        SupprimerLivreResponse response = new SupprimerLivreResponse();
        response.setSuccess(true);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "PreterLivreRequest")
    @ResponsePayload
    public PreterLivreResponse preterLivre(@RequestPayload PreterLivreRequest request) {
        livreService.setDisponibiliteLivre(request.getLivreId(), false);
        PreterLivreResponse response = new PreterLivreResponse();
        response.setSuccess(true);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "RetournerLivreRequest")
    @ResponsePayload
    public RetournerLivreResponse retournerLivre(@RequestPayload RetournerLivreRequest request) {
        livreService.setDisponibiliteLivre(request.getLivreId(), true);
        RetournerLivreResponse response = new RetournerLivreResponse();
        response.setSuccess(true);
        return response;
    }
}
