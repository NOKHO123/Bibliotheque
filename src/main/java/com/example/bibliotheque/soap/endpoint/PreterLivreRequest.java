package com.example.bibliotheque.soap.endpoint;

public class PreterLivreRequest {
	 private Long userId;

	   
	    private Long livreId;

	    public PreterLivreRequest() {}

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
