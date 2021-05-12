package com.bsimm.ctrlcorredor.dtos;

import java.util.List;

import com.bsimm.ctrlcorredor.domain.Evento;

public class PerformanceDTO {
	private List<Evento> maiorAumentoPerformance;
	
	public PerformanceDTO(List<Evento> melhoresEventos) {
		this.maiorAumentoPerformance = melhoresEventos;
	}

	public List<Evento> getMelhoresEventos() {
		return maiorAumentoPerformance;
	}

	public void setMelhoresEventos(List<Evento> melhoresEventos) {
		this.maiorAumentoPerformance = melhoresEventos;
	}
	
}
