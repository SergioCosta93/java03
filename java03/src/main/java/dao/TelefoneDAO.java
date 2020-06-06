package dao;

import java.util.List;

import model.Telefones;

public interface TelefoneDAO {
	public void inserirFuncionario(Telefones telefone);

	public void alterarFuncionario(Telefones telefone);

	public void removerFuncionario(Telefones telefone);

	public Telefones pesquisarTelefones(int id);

	public List<Telefones> listarTodosFuncionarios();
}
