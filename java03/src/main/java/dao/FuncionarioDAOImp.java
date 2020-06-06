package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Funcionarios;
import util.JPAConexao;

public class FuncionarioDAOImp implements FuncionarioDAO {

	EntityManager gerenteDeConexao = null;
	EntityTransaction requisicao = null;

	@Override
	public void inserirFuncionario(Funcionarios funcionario) {

		gerenteDeConexao = JPAConexao.getEntityManager();
		requisicao = gerenteDeConexao.getTransaction();
		requisicao.begin();
		gerenteDeConexao.persist(funcionario);
		requisicao.commit();
		gerenteDeConexao.close();

	}

	@Override
	public void alterarFuncionario(Funcionarios funcionario) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		requisicao = gerenteDeConexao.getTransaction();
		requisicao.begin();
		gerenteDeConexao.merge(funcionario);
		requisicao.commit();
		gerenteDeConexao.close();

	}

	@Override
	public void removerFuncionario(Funcionarios funcionario) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		requisicao = gerenteDeConexao.getTransaction();
		requisicao.begin();
		gerenteDeConexao.remove(funcionario);
		requisicao.commit();
		gerenteDeConexao.close();

	}

	@Override
	public Funcionarios pesquisarFuncionario(int cpf) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		Funcionarios funcionario = gerenteDeConexao.find(Funcionarios.class, cpf);
		return funcionario;
	}

	@Override
	public List<Funcionarios> listarTodosFuncionarios() {
		gerenteDeConexao = JPAConexao.getEntityManager();
		Query query=gerenteDeConexao.createQuery("from funcionario u");
		List<Funcionarios> funcionarios = query.getResultList();
		return funcionarios;
	}

}
