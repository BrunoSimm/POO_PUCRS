package com.bsimm.pontoeletronico.domain.funcionario;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.bsimm.pontoeletronico.domain.AbstractEntity;
import com.bsimm.pontoeletronico.domain.registroponto.RegistroPonto;


@SuppressWarnings("serial")
@Entity
@Table(name = "TB_FUNCIONARIOS")
public class Funcionario extends AbstractEntity<Long> {

	@NotBlank(message = "Nome deve ser preenchido.")
	@Size(max = 60, message = "Nome não deve possuir mais de 60 caracteres.")
	private String nome;
	
	@NotBlank(message = "Senha deve ser preenchida.")
	@Column(nullable = false)
	private String senha;
		
	@Column
	@NotBlank(message = "Cargo deve ser preenchido.")
	private String cargo;
	
	@Column(unique = true)
	@CPF
	@NotBlank
	private String cpf;
	
	@NotBlank(message = "Telefone deve ser preenchido.")
	@Size(max = 20)
	@Column(name = "fone")
	private String telefone;
	
	@NotBlank(message = "Email deve ser preenchido.")
	@Email(message = "Insira um email válido.")
	@Size(max = 255)
	private String email;
	
	@Column(nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private Permissoes permissoes;
	
	@Column
	@NotBlank(message = "Horário de inicio do dia de trabalho deve ser preenchido. Exemplo: 08:12:00")
	//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh:mm:ss")
	@Pattern(regexp="\\d{2}\\:\\d{2}", message = "Horário de Inicio deve seguir o padrão hh:mm")
	private String horarioInicio;
	
	@Column
	@NotBlank(message = "Horário de saida do dia de trabalho deve ser preenchido. Exemplo: 18:00:00")
	//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh:mm:ss")
	@Pattern(regexp="\\d{2}\\:\\d{2}", message = "Horário de Saida (final do turno) deve seguir o padrão hh:mm")
	private String horarioSaida;
	
	@Column
	@NotBlank(message = "O tempo de intervalo deve ser informado")
	@Pattern(regexp="\\d{2}\\:\\d{2}", message = "Tempo de intervalo deve seguir o padrão hh:mm")
	private String tempoIntervalo;
	
	@Column(nullable = true)
	private double bancoDeHoras;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Permissoes getPermissoes() {
		return permissoes;
	}

	public void setPermissoes(Permissoes permissoes) {
		this.permissoes = permissoes;
	}

	public void setBancoDeHoras(double bancoDeHoras) {
		this.bancoDeHoras = bancoDeHoras;
	}

	// 1 funcionario p/ n RegistroPonto
	@OneToMany(mappedBy = "funcionario") //"funcionario" => Nome do atributo no lado forte ( Many (RegistroPonto))
	private List<RegistroPonto> registrosPonto;
	
	public double getBancoDeHoras() {
		return bancoDeHoras;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(String horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public List<RegistroPonto> getRegistrosPonto() {
		return registrosPonto;
	}

	public void setRegistrosPonto(List<RegistroPonto> registrosPonto) {
		this.registrosPonto = registrosPonto;
	}

	public String getTempoIntervalo() {
		return tempoIntervalo;
	}

	public void setTempoIntervalo(String tempoIntervalo) {
		this.tempoIntervalo = tempoIntervalo;
	}
	
}
