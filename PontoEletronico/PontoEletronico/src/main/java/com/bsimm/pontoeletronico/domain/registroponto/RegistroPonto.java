package com.bsimm.pontoeletronico.domain.registroponto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import com.bsimm.pontoeletronico.domain.AbstractEntity;
import com.bsimm.pontoeletronico.domain.funcionario.Funcionario;
import com.fasterxml.jackson.annotation.JsonFormat;

@SuppressWarnings("serial")
@Entity
@Table(name = "TB_REGISTROS_PONTO")
public class RegistroPonto extends AbstractEntity<Long> {

	@ManyToOne
	@JoinColumn(name = "id_funcionario_fk")
	private Funcionario funcionario;
	
	@Column (name = "data_registro")
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy:HH:mm")
	private LocalDateTime dataRegistro;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@NotNull
	private TipoRegistroPonto tipoRegistroPonto;
	
	@Column(nullable = true)
	@Nullable
	private String justificativa;//Utilizado em casos de atrasos ou saidas antecipadas.
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDateTime getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(LocalDateTime dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
}
