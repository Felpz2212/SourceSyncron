package com.sourcesyncron.v1.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "tarefas")
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String descricao;
	
	@Column
	private Boolean publico;
	
	@Column
	private Integer duracao_estimada;
	
	@Column
	private Date data_inicio;
	
	@Column
	private Date data_final;
	
	@ManyToOne
	private Projeto projeto;
	
	@ManyToOne
	@Value(value = "1")
	private Status status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Boolean getPublico() {
		return publico;
	}

	public void setPublico(Boolean publico) {
		this.publico = publico;
	}

	public Integer getDuracao_estimada() {
		return duracao_estimada;
	}

	public void setDuracao_estimada(Integer duracao_estimada) {
		this.duracao_estimada = duracao_estimada;
	}

	public Date getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(Date data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Date getData_final() {
		return data_final;
	}

	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data_final, data_inicio, descricao, duracao_estimada, id, nome, projeto, publico, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(data_final, other.data_final) && Objects.equals(data_inicio, other.data_inicio)
				&& Objects.equals(descricao, other.descricao)
				&& Objects.equals(duracao_estimada, other.duracao_estimada) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(projeto, other.projeto)
				&& Objects.equals(publico, other.publico) && Objects.equals(status, other.status);
	}
	
	
	
}
