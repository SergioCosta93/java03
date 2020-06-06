package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TELEFONE")
public class Telefones {

	// ATRIBUTOS
	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(generator = "S_Telefones")
	@SequenceGenerator(name = "S_Telefones", sequenceName = "S_Telefones", allocationSize = 1)
	private int id;

	@Column(name = "DDD", nullable = false)
	private int ddd;

	@Column(name = "NUMERO", nullable = false)
	private String numero;

	@Column(name = "Funcionarios", nullable = false)
	private List<Funcionarios> funcionarios;

	// CONSTRUTOR VAZIO
	public Telefones() {
	}

	// METODOS GET SET
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<Funcionarios> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionarios> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
