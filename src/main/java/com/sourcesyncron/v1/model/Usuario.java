package com.sourcesyncron.v1.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Usuario() {
		super();
	}

	public Usuario(Long id, String nome, String email, String username, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.username = username;
		this.senha = senha;
	}

	public Usuario(Long id, String nome, String email, String username) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.username = username;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nome;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String senha;
	
	@Column(unique = true)
	private String username;

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, nome, senha, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(email, other.email) && Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha) && Objects.equals(username, other.username);
	}
	
	
	
}
