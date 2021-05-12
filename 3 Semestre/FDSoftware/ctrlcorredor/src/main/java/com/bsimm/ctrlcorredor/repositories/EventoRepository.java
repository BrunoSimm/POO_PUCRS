package com.bsimm.ctrlcorredor.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bsimm.ctrlcorredor.domain.Evento;

@Repository
public class EventoRepository {
	
    private JdbcTemplate jdbcTemplate;

    @Autowired
	public EventoRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
	    this.jdbcTemplate.execute("CREATE TABLE eventos("
	            + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");
	    
	    this.jdbcTemplate.batchUpdate(
	    	    "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
	    	    " ('1','Poa Day Run',10,2,2019,100,1,33,30)");
	    this.jdbcTemplate.batchUpdate(
	    	    "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
	    	    " ('2','Poa Day Run2',19,3,2019,100,1,35,32)");
	    this.jdbcTemplate.batchUpdate(
	    	    "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
	    	    " ('3','Poa Day Run3',22,5,2019,100,0,15,31)");
	    this.jdbcTemplate.batchUpdate(
	    	    "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
	    	    " ('4','Poa Day Run4',15,10,2019,100,1,25,30)");
	    
	    this.jdbcTemplate.batchUpdate(
	    	    "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
	    	    " ('5','Poa Day Run5',11,1,2019,100,1,35,32)");
	    
	    this.jdbcTemplate.batchUpdate(
	    	    "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
	    	    " ('6','Poa Day Run6',11,1,2020,100,1,50,23)");
	}
	
	public EventoRepository() {
		
	}
	

	public List<Evento> findAll() {
		List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
		return resp;
		
	}
	
	public boolean saveEvento(Evento evento) {
		this.jdbcTemplate.update(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
                evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(),
                evento.getDistancia(), evento.getHoras(), evento.getMinutos(), evento.getSegundos());
        return true;
	}

	
   

}
