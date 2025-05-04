package com.example.bibliotheque.soap.endpoint;

public class RetournerLivreRequest {
	private Long userId;

    
    private Long livreId;

    public RetournerLivreRequest() {}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getLivreId() {
		return livreId;
	}

	public void setLivreId(Long livreId) {
		this.livreId = livreId;
	}
	
}
