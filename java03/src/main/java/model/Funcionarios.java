package model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table (name= "Funcionario")
public class Funcionarios {
	
	// ATRIBUTOS
	@Id
	@Column(name = "CPF", nullable = false)
	@GeneratedValue(generator = "S_Funcionarios")
	@SequenceGenerator(name = "S_Funcionarios", sequenceName = "S_Funcionarios", allocationSize = 1)
	private int cpf;
	
	@Column(name = "NOME_COMPLETO", nullable = false)
	private String nomeCompleto;
	
	@Column(name = "LOGRADOURO", nullable = false)
	private String logradouro;
	
	@Column(name = "NUMERO", nullable = false)
	private String numero;
	
	@Column(name = "COMPLEMENTO", nullable = true)
	private String complemento;
	
	@Column(name = "CEP", nullable = false)
	private String cep;
	
	@Column(name = "BAIRRO", nullable = false)
	private String bairro;
	
	@Column(name = "CIDADE", nullable = false)
	private String cidade;
	
	@Column(name = "ESTADO", nullable = false)
	private String estado;
	
	@Column(name = "CARGO", nullable = false)
	private String cargo;
	
	@Column(name = "DATA_CONTRATACAO", nullable = false)
	private Date dataContradado;
	
	@Column(name = "SALARIO_MENSAL", nullable = false)
	private float salarioMensal;
	
	@Column(name = "DATA_NASCIMENTO", nullable = false)
	private Date dataNascimento;
	
	@Column(name = "USUARIO_EMAIL", nullable = false)
	private List<Usuarios> Usuarios;
	
	//CONSTRUTOR VAZIO
	public Funcionarios() {
	}
	
	//METODOS GET SET
	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getDataContradado() {
		return dataContradado;
	}

	public void setDataContradado(Date dataContradado) {
		this.dataContradado = dataContradado;
	}

	public float getSalarioMensal() {
		return salarioMensal;
	}

	public void setSalarioMensal(float salarioMensal) {
		this.salarioMensal = salarioMensal;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Usuarios> getUsuarios() {
		return Usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		Usuarios = usuarios;
	}

}
