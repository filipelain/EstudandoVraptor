package br.com.blog.controller;

import javax.inject.Inject;

import br.com.blog.DAO.UsuarioDAO;
import br.com.blog.model.Usuario;
import br.com.blog.securit.UsuarioLogado;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

public class LoginController {
	
	private UsuarioDAO dao;
	private UsuarioLogado logado;
	private Result result;
	private Validator validator;


	@Inject
	public LoginController(UsuarioDAO dao, UsuarioLogado logado, Result result, Validator validator){
		this.dao = dao;
		this.logado = logado;
		this.result = result;
		this.validator = validator;
	}
    public LoginController(){}
	
	@Path("/lform")
	public void form(){}
	
	
	public void autentica(String nome , String senha){
	Usuario usuario = dao.busca(nome, senha);
	if(usuario != null ){
		logado.login(usuario);
		result.redirectTo(UsuarioController.class).lista();
	}else
	{
		validator.add(new SimpleMessage("login_invalido", "Usuario ou Senha Invalidos") );
		validator.onErrorRedirectTo(UsuarioController.class).form();
	}
		
	}
	
	public void logOut(){
		logado.logout();
		result.redirectTo(this).form();
	}

}
