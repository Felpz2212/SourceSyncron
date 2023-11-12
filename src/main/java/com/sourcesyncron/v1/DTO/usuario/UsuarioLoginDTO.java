package com.sourcesyncron.v1.DTO.usuario;

import java.io.Serializable;
import java.util.Objects;

public class UsuarioLoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	

	private String email;
	private String pwd;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(email, pwd);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioLoginDTO other = (UsuarioLoginDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(pwd, other.pwd);
	}
	
	
	
}
