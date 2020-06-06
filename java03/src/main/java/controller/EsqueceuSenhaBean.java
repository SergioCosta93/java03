package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import dao.UsuarioDAOImp;
import model.Usuarios;

@ManagedBean(name = "EsqueceuSenhaBean")
@RequestScoped
public class EsqueceuSenhaBean {
	// ATRIBUTOS
	private Usuarios usuario;
	private List<Usuarios> usuarios;
	private String emailInformado;
	private UsuarioDAO usuarioDAO;
	private static final String TELALOGIN = "../Login.xhtml";

	public EsqueceuSenhaBean() {
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

	public String getEmailInformado() {
		return emailInformado;
	}

	public void setEmailInformado(String emailInformado) {
		this.emailInformado = emailInformado;
	}

	// METODOS
	public void recuperarSenha() {
		for (Usuarios usuarioListar : usuarios) {
			if (usuarioListar.equals(usuario.getEmail().equals(emailInformado))) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Emal válido", "enviando para seu Email"));
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Email invalido!"));
			}
		}

	}

	public void cencelar() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(TELALOGIN);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
