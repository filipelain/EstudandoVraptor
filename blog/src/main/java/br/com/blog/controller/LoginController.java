package br.com.blog.controller;

import javax.inject.Inject;

import br.com.blog.DAO.UsuarioDAO;
import br.com.blog.model.Usuario;
import br.com.blog.securit.Open;
import br.com.blog.securit.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;




@Controller
public class LoginController {
	

	private UsuarioDAO dao;
	private UsuarioLogado logado;
	private Result result;
	private Validator validator;

	@Inject
	public LoginController(UsuarioDAO dao, UsuarioLogado logado, Result result, Validator validator) {
		this.dao = dao;
		this.logado = logado;
		this.result = result;
		this.validator = validator;
	
	}

	public LoginController() {
	}

	@Open
	public void form() {
	}

	@Open
	public void autentica(String usuario, String senha) {
		Usuario pessoa = dao.busca(usuario, senha);
		if (pessoa != null) {
			logado.login(pessoa);
			result.redirectTo(IndexController.class).index();
		} else {
			validator.add(new SimpleMessage("login_invalido", "Usuario ou Senha Invalidos"));
			validator.onErrorRedirectTo(this).form();
		}
	}

	@Open
	public void logout() {
		logado.logout();
		result.redirectTo(this).form();
	}
}
