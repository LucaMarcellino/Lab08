package it.polito.tdp.extflightdelays.model;

public class Arco {
 
	private Airport oA;
	private Airport dA;
	private long media;
	
	
	public Arco(Airport oA, Airport dA, long media) {
		super();
		this.oA = oA;
		this.dA = dA;
		this.media = media;
	}


	public Airport getoA() {
		return oA;
	}


	public void setoA(Airport oA) {
		this.oA = oA;
	}


	public Airport getdA() {
		return dA;
	}


	public void setdA(Airport dA) {
		this.dA = dA;
	}


	public long getMedia() {
		return media;
	}


	public void setMedia(long media) {
		this.media = media;
	}


	@Override
	public String toString() {
		return "Aereoporto partenza=" + oA + ", aereporto Arrivo=" + dA + ", Distanza Media" + media;
	}
	
	
	
	
	
}
