package com.bsimm.ctrlcorredor.dtos;

public class EstatisticasDTO {
	
	private String media;
	private String mediana;
	private String desvioPadrao;
	private int qtdEventos;
	
	public EstatisticasDTO(String media, String mediana, String desvioPadrao, int qtdEventos) {
		super();
		this.media = media;
		this.mediana = mediana;
		this.desvioPadrao = desvioPadrao;
		this.qtdEventos = qtdEventos;
	}
	
	public String getMedia() {
		return media;
	}
	public void setMedia(String media) {
		this.media = media;
	}
	public String getMediana() {
		return mediana;
	}
	public void setMediana(String mediana) {
		this.mediana = mediana;
	}
	public String getDesvioPadrao() {
		return desvioPadrao;
	}
	public void setDesvioPadrao(String desvioPadrao) {
		this.desvioPadrao = desvioPadrao;
	}
	public int getQtdEventos() {
		return qtdEventos;
	}
	public void setQtdEventos(int qtdEventos) {
		this.qtdEventos = qtdEventos;
	}
	
}