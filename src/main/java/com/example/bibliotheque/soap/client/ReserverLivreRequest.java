package com.example.bibliotheque.soap.client;

public class ReserverLivreRequest {
	private Long livreId;

    
    private Long userId;

   
    private String dateDebut; 

    
    private String dateFin;

    public ReserverLivreRequest() {}

	public Long getLivreId() {
		return livreId;
	}

	public void setLivreId(Long livreId) {
		this.livreId = livreId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	

}
