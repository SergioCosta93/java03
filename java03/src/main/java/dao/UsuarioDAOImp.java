package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Usuarios;
import util.JPAConexao;

public class UsuarioDAOImp implements UsuarioDAO {
	EntityManager gerenteDeConexao = null;
	EntityTransaction requisicao = null;

	@Override
	public void inserirUsuario(Usuarios usuario) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		requisicao = gerenteDeConexao.getTransaction();
		requisicao.begin();
		gerenteDeConexao.persist(usuario);
		requisicao.commit();
		gerenteDeConexao.close();

	}

	@Override
	public void alterarUsuario(Usuarios usuario) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		requisicao = gerenteDeConexao.getTransaction();
		requisicao.begin();
		gerenteDeConexao.merge(usuario);
		requisicao.commit();
		gerenteDeConexao.close();

	}

	@Override
	public void removerUsuario(Usuarios usuario) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		requisicao = gerenteDeConexao.getTransaction();
		requisicao.begin();
		gerenteDeConexao.remove(usuario);
		requisicao.commit();
		gerenteDeConexao.close();

	}

	@Override
	public Usuarios pesquisarUsuario(String email) {
		gerenteDeConexao = JPAConexao.getEntityManager();
		Usuarios usuario = gerenteDeConexao.find(Usuarios.class, email);
		return usuario;
	}

	@Override
	public List<Usuarios> listarTodosUsuario() {
		gerenteDeConexao = JPAConexao.getEntityManager();
		Query query = gerenteDeConexao.createQuery("from usuario u");
		List<Usuarios> usuarios = query.getResultList();
		return usuarios;
	}

}
