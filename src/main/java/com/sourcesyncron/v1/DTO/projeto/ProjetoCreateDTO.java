package com.sourcesyncron.v1.DTO.projeto;

public class ProjetoCreateDTO {
	
	private String nome;
	private String descricao;
	private String github_link;
	private Long owner;
	
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
	public String getGithub_link() {
		return github_link;
	}
	public void setGithub_link(String github_link) {
		this.github_link = github_link;
	}
	public Long getOwner() {
		return owner;
	}
	public void setOwner(Long owner) {
		this.owner = owner;
	}
	public ProjetoCreateDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProjetoCreateDTO(String nome, String descricao, String github_link, Long owner) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.github_link = github_link;
		this.owner = owner;
	}
	
	
}
