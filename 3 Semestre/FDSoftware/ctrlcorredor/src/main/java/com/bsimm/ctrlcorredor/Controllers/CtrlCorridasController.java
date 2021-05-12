package com.bsimm.ctrlcorredor.Controllers;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bsimm.ctrlcorredor.domain.Corredor;
import com.bsimm.ctrlcorredor.domain.Evento;
import com.bsimm.ctrlcorredor.dtos.EstatisticasDTO;
import com.bsimm.ctrlcorredor.dtos.PerformanceDTO;
import com.bsimm.ctrlcorredor.repositories.CorredorRepository;
import com.bsimm.ctrlcorredor.repositories.EventoRepository;
import com.bsimm.ctrlcorredor.services.EventoService;

@RestController
@RequestMapping("/ctrlCorridas")
public class CtrlCorridasController {

    @Autowired
    EventoRepository eventoRepository;
    
    @Autowired
    CorredorRepository corredorRepository;
    
    @Autowired
    EventoService eventoService;

    @GetMapping("/corredor")
    @CrossOrigin(origins = "*")
    public List<Corredor> consultaCorredor() {
        return corredorRepository.findAll();
    }

    @PostMapping("/corredor")
    @CrossOrigin(origins = "*")
    public Corredor cadastraCorredor(@RequestBody final Corredor corredor) {
        return corredorRepository.saveCorredor(corredor);
    }

    @GetMapping("/eventos")
    @CrossOrigin(origins = "*")
    public List<Evento> consultaEventos() {
        return eventoRepository.findAll();
    }

    @PostMapping("/eventos") // adiciona evento no único corredor
    @CrossOrigin(origins = "*")
    public boolean informaEvento(@RequestBody final Evento evento) {
        return eventoRepository.saveEvento(evento);
    }
    
    @GetMapping("/estatisticas") 
    @CrossOrigin(origins = "*") 
    public EstatisticasDTO estatisticas(@RequestParam final int distancia){ 
    	
    	String media;
    	String mediana;
    	String desvioPadrao;
    	
    	//TODO
    	List<Evento> eventos = eventoRepository.findAll();
    			//.getByDistancia(distancia);
    	
    	List<Evento> filtredAndSortedList = eventos.stream()
    			.filter(evento -> evento.getDistancia() == distancia)
    			.sorted(
    					Comparator.comparingInt(Evento::getAno)
    					.thenComparingInt(Evento::getMes)
    					.thenComparingInt(Evento::getDia)
    					.thenComparingInt(Evento::getHoras)
    					.thenComparingInt(Evento::getMinutos)
    					.thenComparingInt(Evento::getSegundos)
    					)
    			.collect(Collectors.toList());
    	
    	filtredAndSortedList.forEach(System.out::println);
    	    	
    	mediana = eventoService.getMediana(filtredAndSortedList);
    			
    	media = eventoService.getMedia(filtredAndSortedList);
    	
    	desvioPadrao = eventoService.getDesvioPadrao(filtredAndSortedList);
    	
    	EstatisticasDTO edto = new EstatisticasDTO(media, mediana, desvioPadrao, filtredAndSortedList.size());
    	return edto;
    }
    
    @GetMapping("/aumentoPerformance") 
    @CrossOrigin(origins = "*") 
    public PerformanceDTO aumentoPerformance(@RequestParam final int distancia, @RequestParam final int ano){
    	
    	List<Evento> eventos = eventoRepository.findAll();

    	List<Evento> filtredAndSortedList = eventos.stream()
    			.filter(evento -> evento.getDistancia() == distancia && evento.getAno() == ano)
    			.sorted(
					Comparator.comparingInt(Evento::getAno)
					.thenComparingInt(Evento::getMes)
					.thenComparingInt(Evento::getDia)
					)
    			.collect(Collectors.toList());
    	
    	
    	List<Evento> melhoresPerfomances = eventoService.getMelhorAumentoPerformances(filtredAndSortedList);
   
    	PerformanceDTO maiorAumentoPerformance = new PerformanceDTO(melhoresPerfomances);
    	
    	return maiorAumentoPerformance;
    }
    
   
}

