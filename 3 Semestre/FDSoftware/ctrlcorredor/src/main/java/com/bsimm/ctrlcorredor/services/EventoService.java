package com.bsimm.ctrlcorredor.services;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bsimm.ctrlcorredor.domain.Evento;

@Service
public class EventoService {
	
	
	public EventoService() {
		
	}

	 public String getMediana(List<Evento> filtredAndSortedList) {
	    	int size = filtredAndSortedList.size();
	    	
	    	if (size % 2 == 0) {
	    		Evento e1 = filtredAndSortedList.get(size/2);
	    		Evento e2 = filtredAndSortedList.get((size/2)+1);
	    		
	    		LocalTime t1 = LocalTime.of(e1.getHoras(),e1.getMinutos(),e1.getSegundos());
	    		LocalTime t2 = LocalTime.of(e2.getHoras(),e2.getMinutos(),e2.getSegundos());
	    		
	    		long somaNanosegundos = t1.toNanoOfDay();
	        	somaNanosegundos += t2.toNanoOfDay();
	        	
	        	return LocalTime.ofNanoOfDay(somaNanosegundos / (2)).toString();
	    		
	    	} else {
	    		Evento e1 = filtredAndSortedList.get((int)Math.ceil(size/2));
	    		return LocalTime.of(e1.getHoras(),e1.getMinutos(),e1.getSegundos()).toString();
	    	}
	    	
	    }
	 
	 public String getMedia(List<Evento> filtredAndSortedList) {
	    	long somaNanosegundos = 0;
	    	
	    	for (Evento evento : filtredAndSortedList) {
	    		//Cria a instancia de tempo de cada evento.
	    		LocalTime duracaoEvento = LocalTime.of(evento.getHoras(),evento.getMinutos(),evento.getSegundos());
	    		somaNanosegundos += duracaoEvento.toNanoOfDay();
			}
	    	
	        return LocalTime.ofNanoOfDay(somaNanosegundos / filtredAndSortedList.size()).toString();
	    }
	 
	 public String getDesvioPadrao(List<Evento> filtredAndSortedList) {
	    	long somaNanosegundos = 0;
	    	LocalTime media;
	    	double desvioPadraoNano = 0;
	    	
	    	for (Evento evento : filtredAndSortedList) {
	    		//Cria a instancia de tempo de cada evento.
	    		LocalTime duracaoEvento = LocalTime.of(evento.getHoras(),evento.getMinutos(),evento.getSegundos());
	    		somaNanosegundos += duracaoEvento.toNanoOfDay();
			}
	    	
	    	media = LocalTime.ofNanoOfDay(somaNanosegundos / filtredAndSortedList.size());
	    	
	    	for (Evento evento : filtredAndSortedList) {
	    		LocalTime duracaoEvento = LocalTime.of(evento.getHoras(),evento.getMinutos(),evento.getSegundos());
	    		long varianciaEvento = duracaoEvento.toNanoOfDay() - media.toNanoOfDay();
	    		desvioPadraoNano += Math.pow(varianciaEvento, 2);
	    		
			}
	    	
	    	desvioPadraoNano = Math.sqrt((desvioPadraoNano / filtredAndSortedList.size()));
	    	
	    	return LocalTime.ofNanoOfDay((long) desvioPadraoNano).toString();
	    }

	public List<Evento> getMelhorAumentoPerformances(List<Evento> filtredAndSortedList) {
		List<Evento> melhoresPerfomances = new ArrayList<Evento>();
		long melhorGanhoPerformance = 0;
		
    	if (filtredAndSortedList.size() <= 1) {
    		return melhoresPerfomances; //Vazio
    	}
    	
    	if(filtredAndSortedList.size() >= 2) {
    		
    		//Definindo as duas primeiras corridas como melhores.
    		melhoresPerfomances.add(filtredAndSortedList.get(0));
        	melhoresPerfomances.add(filtredAndSortedList.get(1));
    		
    		LocalTime duracaoEventoInicial = LocalTime.of(filtredAndSortedList.get(0).getHoras(),
    				filtredAndSortedList.get(0).getMinutos(),filtredAndSortedList.get(0).getSegundos());
    		
    		LocalTime duracaoSegundoEventoInicial = LocalTime.of(filtredAndSortedList.get(1).getHoras(),
    				filtredAndSortedList.get(1).getMinutos(),filtredAndSortedList.get(1).getSegundos());
    		
    		melhorGanhoPerformance = duracaoSegundoEventoInicial.toNanoOfDay() - duracaoEventoInicial.toNanoOfDay();
    		
    		
    		for (int i = 0; i <= filtredAndSortedList.size(); i++) {
    			
    			if (i == filtredAndSortedList.size()-1) { //Ultime elemento (event).
    				return melhoresPerfomances;
    			} else {
    				System.out.println(i + " => "+ filtredAndSortedList.get(i));
    				LocalTime duracaoEventoAtual = LocalTime.of(filtredAndSortedList.get(i).getHoras(),
        					filtredAndSortedList.get(i).getMinutos(),filtredAndSortedList.get(i).getSegundos());
        			
        			LocalTime duracaoEventoProximo = LocalTime.of(filtredAndSortedList.get(i+1).getHoras(),
        					filtredAndSortedList.get(i+1).getMinutos(),filtredAndSortedList.get(i+1).getSegundos());
        			
        			//Compara a diferença no tempo de prova dos indices atuais com o melhor tempo já registrado.
        			if (duracaoEventoProximo.toNanoOfDay() - duracaoEventoAtual.toNanoOfDay() < melhorGanhoPerformance ) {
        				melhoresPerfomances.clear();
        				melhoresPerfomances.add(filtredAndSortedList.get(i));
        				melhoresPerfomances.add(filtredAndSortedList.get(i+1));
        				
        				melhorGanhoPerformance = duracaoEventoProximo.toNanoOfDay() - duracaoEventoAtual.toNanoOfDay();
        			}
    				
    			}
    			
    		}
    		return melhoresPerfomances;
    	}
    	
		return melhoresPerfomances;
	}

}
