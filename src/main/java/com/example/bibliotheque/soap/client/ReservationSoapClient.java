package com.example.bibliotheque.soap.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.time.LocalDate;

@Component
public class ReservationSoapClient {

    @Autowired
    private WebServiceTemplate webServiceTemplate;

    public boolean reserverLivre(Long livreId, Long userId, LocalDate debut, LocalDate fin) {
        ReserverLivreRequest request = new ReserverLivreRequest();
        request.setLivreId(livreId);
        request.setUserId(userId);
        request.setDateDebut(debut.toString());
        request.setDateDebut(fin.toString());

        ReservesssrLivreResponse response = new ReservesssrLivreResponse();
                webServiceTemplate.marshalSendAndReceive("http://localhost:8080/ws", request);

        return response.isSuccess();
    }
}
