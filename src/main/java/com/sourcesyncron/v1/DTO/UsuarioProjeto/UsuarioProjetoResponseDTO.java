package com.sourcesyncron.v1.DTO.UsuarioProjeto;

import java.util.Objects;

import com.sourcesyncron.v1.DTO.projeto.ProjetoResponseDTO;
import com.sourcesyncron.v1.DTO.usuario.UsuarioDTO;
import com.sourcesyncron.v1.model.TiposUsuarios;

public class UsuarioProjetoResponseDTO {
	
	private Long id;
	private UsuarioDTO usuario;
	private ProjetoResponseDTO projeto;
	private TiposUsuarios tipo;
	
	public UsuarioProjetoResponseDTO() {
		super();
	}

	public UsuarioProjetoResponseDTO(Long id, UsuarioDTO usuario, ProjetoResponseDTO projeto, TiposUsuarios tipo) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.projeto = projeto;
		this.tipo = tipo;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public ProjetoResponseDTO getProjeto() {
		return projeto;
	}

	public void setProjeto(ProjetoResponseDTO projeto) {
		this.projeto = projeto;
	}

	public TiposUsuarios getTipo() {
		return tipo;
	}

	public void setTipo(TiposUsuarios tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, projeto, tipo, usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioProjetoResponseDTO other = (UsuarioProjetoResponseDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(projeto, other.projeto)
				&& Objects.equals(tipo, other.tipo) && Objects.equals(usuario, other.usuario);
	}
	
	
	
	
}
