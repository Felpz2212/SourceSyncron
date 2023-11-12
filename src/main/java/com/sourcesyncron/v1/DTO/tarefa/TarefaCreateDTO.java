package com.sourcesyncron.v1.DTO.tarefa;

import java.util.Date;
import java.util.Objects;

public class TarefaCreateDTO {
	
	private Long id;
	private Date data_final;
	private Date data_inicial;
	private String descricao;
	private int duracao;
	private String nome;
	private boolean publico;
	private Long projeto_id;
	private Long status_id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getData_final() {
		return data_final;
	}
	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}
	public Date getData_inicial() {
		return data_inicial;
	}
	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isPublico() {
		return publico;
	}
	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	public Long getProjeto_id() {
		return projeto_id;
	}
	public void setProjeto_id(Long projeto_id) {
		this.projeto_id = projeto_id;
	}
	public Long getStatus_id() {
		return status_id;
	}
	public void setStatus_id(Long status_id) {
		this.status_id = status_id;
	}
	public TarefaCreateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TarefaCreateDTO(Date data_final, Date data_inicial, String descricao, int duracao, String nome,
			boolean publico, Long projeto_id, Long status_id) {
		super();
		this.data_final = data_final;
		this.data_inicial = data_inicial;
		this.descricao = descricao;
		this.duracao = duracao;
		this.nome = nome;
		this.publico = publico;
		this.projeto_id = projeto_id;
		this.status_id = status_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(data_final, data_inicial, descricao, duracao, nome, projeto_id, publico, status_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarefaCreateDTO other = (TarefaCreateDTO) obj;
		return Objects.equals(data_final, other.data_final) && Objects.equals(data_inicial, other.data_inicial)
				&& Objects.equals(descricao, other.descricao) && duracao == other.duracao
				&& Objects.equals(nome, other.nome) && Objects.equals(projeto_id, other.projeto_id)
				&& publico == other.publico && Objects.equals(status_id, other.status_id);
	}
	
	
	
	
}
