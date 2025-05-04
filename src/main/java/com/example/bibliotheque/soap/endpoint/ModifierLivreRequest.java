package com.example.bibliotheque.soap.endpoint;

public class ModifierLivreRequest {
	private Long livreId;
	private String auteur;
	private String titre;
	private Boolean disponible;
	
	 public ModifierLivreRequest() {}

	public Long getLivreId() {
		return livreId;
	}

	public void setLivreId(Long livreId) {
		this.livreId = livreId;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Boolean getDisponible() {
		return disponible;
	}

	public void setDisponible(Boolean disponible) {
		this.disponible = disponible;
	}
	

}
