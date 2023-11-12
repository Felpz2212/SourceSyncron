package com.sourcesyncron.v1.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "usuarios_tarefas")
public class UsuarioTarefas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public UsuarioTarefas() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Projeto projeto;
	
	@ManyToOne
	private Tarefa tarefa;
	
	@ManyToOne
	private Usuario usuario;
	
	public UsuarioTarefas(Projeto projeto, Tarefa tarefa, Usuario usuario) {
		super();
		this.projeto = projeto;
		this.tarefa = tarefa;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, projeto, tarefa, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioTarefas other = (UsuarioTarefas) obj;
		return Objects.equals(id, other.id) && Objects.equals(projeto, other.projeto)
				&& Objects.equals(tarefa, other.tarefa) && Objects.equals(usuario, other.usuario);
	}
	
	
	
}
