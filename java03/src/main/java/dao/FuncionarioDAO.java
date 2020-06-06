package dao;

import java.util.List;

import model.Funcionarios;

public interface FuncionarioDAO {
	public void inserirFuncionario(Funcionarios funcionario);

	public void alterarFuncionario(Funcionarios funcionario);

	public void removerFuncionario(Funcionarios funcionario);

	public Funcionarios pesquisarFuncionario(int cpf);

	public List<Funcionarios> listarTodosFuncionarios();

}
