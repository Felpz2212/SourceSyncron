package com.sourcesyncron.v1.DTO.UsuarioTarefa;

import java.util.Objects;

import com.sourcesyncron.v1.DTO.projeto.ProjetoResponseDTO;
import com.sourcesyncron.v1.DTO.tarefa.TarefaResponseDTO;
import com.sourcesyncron.v1.DTO.usuario.UsuarioDTO;

public class UsuarioTarefaResponseDTO {
	
	private Long id;
	private ProjetoResponseDTO projeto;
	private TarefaResponseDTO tarefa;
	private UsuarioDTO usuario;
	public UsuarioTarefaResponseDTO(Long id, ProjetoResponseDTO projeto, TarefaResponseDTO tarefa, UsuarioDTO usuario) {
		super();
		this.id = id;
		this.projeto = projeto;
		this.tarefa = tarefa;
		this.usuario = usuario;
	}
	public UsuarioTarefaResponseDTO() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ProjetoResponseDTO getProjeto() {
		return projeto;
	}
	public void setProjeto(ProjetoResponseDTO projeto) {
		this.projeto = projeto;
	}
	public TarefaResponseDTO getTarefa() {
		return tarefa;
	}
	public void setTarefa(TarefaResponseDTO tarefa) {
		this.tarefa = tarefa;
	}
	public UsuarioDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioDTO usuario) {
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
		UsuarioTarefaResponseDTO other = (UsuarioTarefaResponseDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(projeto, other.projeto)
				&& Objects.equals(tarefa, other.tarefa) && Objects.equals(usuario, other.usuario);
	}
	
	
	
	
}
