package br.com.blog.securit;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.blog.model.Usuario;



@Named
@SessionScoped
public class UsuarioLogado implements Serializable {

	private Usuario usuario;

	public void login(Usuario usuario) {
		this.usuario = usuario;
	}

	public void logout() {
		this.usuario = null;
	}

	public boolean isLogged() {

		return this.usuario != null;
	}

	public Usuario getUsuario() {
		return usuario;
	}
}
