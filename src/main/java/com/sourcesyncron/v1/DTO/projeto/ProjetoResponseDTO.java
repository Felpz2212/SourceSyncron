package com.sourcesyncron.v1.DTO.projeto;

import java.util.Objects;

import com.sourcesyncron.v1.DTO.usuario.UsuarioDTO;

public class ProjetoResponseDTO {
	
	private Long id;
	private String nome;
	private String descricao;
	private UsuarioDTO usuario;
	private String github_link;
	
	public ProjetoResponseDTO() {
		super();
	}

	public ProjetoResponseDTO(Long id, String nome, String descricao, UsuarioDTO usuario, String github_link) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.usuario = usuario;
		this.github_link = github_link;
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

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public String getGithub_link() {
		return github_link;
	}

	public void setGithub_link(String github_link) {
		this.github_link = github_link;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, github_link, id, nome, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProjetoResponseDTO other = (ProjetoResponseDTO) obj;
		return Objects.equals(descricao, other.descricao) && Objects.equals(github_link, other.github_link)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(usuario, other.usuario);
	}



	
	
}
