package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Telefones;
import util.JPAConexao;

public class TelefoneDAOImp implements TelefoneDAO {
	EntityManager gerenteDeConexao = null;
	EntityTransaction requisicao = null;

	@Override
	public void inserirFuncionario(Telefones telefone) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		requisicao = gerenteDeConexao.getTransaction();
		requisicao.begin();
		gerenteDeConexao.persist(telefone);
		requisicao.commit();
		gerenteDeConexao.close();

	}

	@Override
	public void alterarFuncionario(Telefones telefone) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		requisicao = gerenteDeConexao.getTransaction();
		requisicao.begin();
		gerenteDeConexao.merge(telefone);
		requisicao.commit();
		gerenteDeConexao.close();

	}

	@Override
	public void removerFuncionario(Telefones telefone) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		requisicao = gerenteDeConexao.getTransaction();
		requisicao.begin();
		gerenteDeConexao.remove(telefone);
		requisicao.commit();
		gerenteDeConexao.close();

	}

	@Override
	public Telefones pesquisarTelefones(int id) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		Telefones telefone = gerenteDeConexao.find(Telefones.class, id);
		return telefone;
	}

	@Override
	public List<Telefones> listarTodosFuncionarios() {
		gerenteDeConexao = JPAConexao.getEntityManager();
		Query query = gerenteDeConexao.createQuery("from telefons u");
		List<Telefones> telefones = query.getResultList();
		return telefones;
	}

}
