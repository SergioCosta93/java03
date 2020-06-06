package dao;

import java.util.List;

import model.Usuarios;

public interface UsuarioDAO {
	public void inserirUsuario(Usuarios usuario);

	public void alterarUsuario(Usuarios usuario);

	public void removerUsuario(Usuarios usuario);

	public Usuarios pesquisarUsuario(String email);

	public List<Usuarios> listarTodosUsuario();
}
