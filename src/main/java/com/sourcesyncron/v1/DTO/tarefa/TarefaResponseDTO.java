package com.sourcesyncron.v1.DTO.tarefa;

import java.util.Objects;

import com.sourcesyncron.v1.DTO.projeto.ProjetoResponseDTO;
import com.sourcesyncron.v1.model.Status;

public class TarefaResponseDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private ProjetoResponseDTO projeto;
	private Status status;
	
	public TarefaResponseDTO(Long id, String nome, String descricao, ProjetoResponseDTO projeto, Status status) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.projeto = projeto;
		this.status = status;
	}

	public TarefaResponseDTO() {
		super();
	}

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

	public ProjetoResponseDTO getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoResponseDTO projeto) {
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
		return Objects.hash(descricao, id, nome, projeto, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarefaResponseDTO other = (TarefaResponseDTO) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(projeto, other.projeto)
				&& Objects.equals(status, other.status);
	}
	
	
	
}
