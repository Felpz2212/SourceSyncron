package com.sourcesyncron.v1.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "projetos")
public class Projeto implements Serializable{

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
	
	@ManyToOne
	private Usuario owner;
	
	@Column
	private String github_link;

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

	public Usuario getOwner() {
		return owner;
	}

	public void setOwner(Usuario owner) {
		this.owner = owner;
	}

	public String getGithub_link() {
		return github_link;
	}

	public void setGithub_link(String github_link) {
		this.github_link = github_link;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, github_link, id, nome, owner, publico);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(github_link, other.github_link)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(owner, other.owner) && Objects.equals(publico, other.publico);
	}

	public Projeto(Long id, String nome, String descricao, Boolean publico, Usuario owner, String github_link) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.publico = publico;
		this.owner = owner;
		this.github_link = github_link;
	}
	
	public Projeto(String nome, String descricao, Boolean publico, Usuario owner, String github_link) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.publico = publico;
		this.owner = owner;
		this.github_link = github_link;
	}

	public Projeto() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
}
