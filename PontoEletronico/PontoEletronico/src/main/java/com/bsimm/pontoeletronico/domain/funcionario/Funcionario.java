package com.bsimm.pontoeletronico.domain.funcionario;

import java.sql.Time;
import java.time.LocalTime;
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
	@NotBlank(message = "CPF deve ser informado.")
	private String cpf;
	
	@NotBlank(message = "Telefone deve ser preenchido.")
	@Size(max = 20)
	@Column(name = "fone")
	private String telefone;
	
	@NotBlank(message = "Email deve ser preenchido adequadamente.")
	@Email(message = "Insira um email válido.")
	@Size(max = 255)
	private String email;
	
	@Column(nullable = false)
	@NotNull
	@Enumerated(EnumType.STRING)
	private Permissoes permissoes;
	
	@Column
	@NotNull(message = "Horario de Inicio não pode ser nulo.")
	//@NotBlank(message = "Horário de inicio do dia de trabalho deve ser preenchido. Exemplo: 08:12:00")
	//@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "hh:mm:ss")
	private LocalTime horarioInicio;
	
	//TODO -> VERIFICAR VALIDAÇÕES DA CHAMADA CADASTRA FUNCIONARIO
	
	@Column
	@NotNull(message = "Horario de Saída não pode ser nulo.")
	private LocalTime horarioSaida;
	
	@Column
	@NotNull(message = "Tempo de intervalo não pode ser nulo.")
	//@NotBlank(message = "O tempo de intervalo deve ser informado")
	private LocalTime tempoIntervalo;
	
	@Column(nullable = true)
	private LocalTime bancoDeHoras;
	
	// 1 funcionario p/ n RegistroPonto
	@OneToMany(mappedBy = "funcionario") //"funcionario" => Nome do atributo no lado forte ( Many (RegistroPonto))
	private List<RegistroPonto> registrosPonto;
	
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

	public void setBancoDeHoras(LocalTime bancoDeHoras) {
		this.bancoDeHoras = bancoDeHoras;
	}

	
	
	public LocalTime getBancoDeHoras() {
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

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioSaida() {
		return horarioSaida;
	}

	public void setHorarioSaida(LocalTime horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public List<RegistroPonto> getRegistrosPonto() {
		return registrosPonto;
	}

	public void setRegistrosPonto(List<RegistroPonto> registrosPonto) {
		this.registrosPonto = registrosPonto;
	}

	public LocalTime getTempoIntervalo() {
		return tempoIntervalo;
	}

	public void setTempoIntervalo(LocalTime tempoIntervalo) {
		this.tempoIntervalo = tempoIntervalo;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
