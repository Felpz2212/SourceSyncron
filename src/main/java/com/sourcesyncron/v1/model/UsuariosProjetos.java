package com.sourcesyncron.v1.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity(name = "usuarios_projetos")
public class UsuariosProjetos implements Serializable {

	public UsuariosProjetos(TiposUsuarios tipoUsuario, Usuario usuario, Projeto projeto) {
		super();
		this.tipoUsuario = tipoUsuario;
		this.usuario = usuario;
		this.projeto = projeto;
	}
	
	public UsuariosProjetos() {
		
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private TiposUsuarios tipoUsuario;
	
	@ManyToOne
	private Usuario usuario;
	
	@ManyToOne
	private Projeto projeto;

	@Override
	public int hashCode() {
		return Objects.hash(id, projeto, tipoUsuario, usuario);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TiposUsuarios getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TiposUsuarios tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuariosProjetos other = (UsuariosProjetos) obj;
		return Objects.equals(id, other.id) && Objects.equals(projeto, other.projeto)
				&& Objects.equals(tipoUsuario, other.tipoUsuario) && Objects.equals(usuario, other.usuario);
	}
	
	
	
}
