package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import dao.UsuarioDAOImp;
import model.Usuarios;

@ManagedBean(name = "LoginBean")
@SessionScoped
public class LoginBean {

	// ATRIBUTOS
	private Usuarios usuario;
	private List<Usuarios> usuarios;
	private String usuarioInformado;
	private String senhaInformada;
	private UsuarioDAO usuarioDAO;
	private static final String LOGINADM = "admin";
	private static final String SENHAADM = "admin";
	private static final String PAGINAHOME="/view/home/home.xhtml";

	// CONSTRUTOR
	public LoginBean() {
		this.usuario = new Usuarios();
		this.usuarios = new ArrayList<Usuarios>();
		this.usuarioDAO = new UsuarioDAOImp();
	}

	// METODOS GET E SET

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}

	public String getUsuarioInformado() {
		return usuarioInformado;
	}

	public void setUsuarioInformado(String usuarioInformado) {
		this.usuarioInformado = usuarioInformado;
	}

	public String getSenhaInformada() {
		return senhaInformada;
	}

	public void setSenhaInformada(String senhaInformada) {
		this.senhaInformada = senhaInformada;
	}

	// METODOS
	public String entrar() {
		Usuarios usuarioLogado = null;
		this.usuarios = this.usuarioDAO.listarTodosUsuario();
		for (Usuarios usuarioListar : usuarios) {
			if (usuarioInformado.equals(LOGINADM) && senhaInformada.equals(SENHAADM)) {
				try {
					FacesContext.getCurrentInstance().getExternalContext().redirect(PAGINAHOME);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return "usuario root";
			} else if (usuarioListar.getEmail().equals(usuario.getEmail())
					&& usuarioListar.getSenha().equals(usuario.getSenha())) {
				usuarioLogado = usuarioListar;
			}
		}

		if (usuarioLogado != null) {
			HttpSession sessao = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			sessao.setAttribute("usuarioLogado", usuarioLogado);
			return "/view/home/home.xhtml?faces-redirect=true&amp;includeViewParams=true";

		} else {
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Usuário invalido!!!"));
			return "";
		}

	}

}
