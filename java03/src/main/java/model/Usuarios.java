package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuarios {

	// ATRIBUTOS
	@Id
	@Column(name = "EMAIL", nullable = false)
	@GeneratedValue(generator = "S_USUARIOS")
	@SequenceGenerator(name = "S_USUARIOS", sequenceName = "S_USUARIOS", allocationSize = 1)
	private String email;

	@Column(name = "SENHA", nullable = false)
	private String senha;

	// CONSTRUTOR VAZIO
	public Usuarios() {
	}

	// METODOS GET SET
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

}
