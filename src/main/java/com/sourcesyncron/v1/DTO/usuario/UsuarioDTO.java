package com.sourcesyncron.v1.DTO.usuario;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String username;
	
	public UsuarioDTO(Long id, String nome, String email, String username) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.username = username;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(username, other.username);
	}
	
	
}
