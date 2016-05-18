package br.com.blog.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.blog.DAO.UsuarioDAO;
import br.com.blog.model.Usuario;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {

	
	private Result result;
	private Validator validator;
	private UsuarioDAO dao;

	@Inject
	public UsuarioController(UsuarioDAO dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	public UsuarioController() {
		// TODO Auto-generated constructor stub
	}

	@Path("/form")
	public void form() {
	}

	@IncludeParameters
	public void adciona(@Valid Usuario usuario) {
		validator.onErrorRedirectTo(this).form();
		dao.novo(usuario);
		result.redirectTo(this).lista();
	}

	@Path("/lista")
	public void lista() {
		List<Usuario> usuarios = dao.lista();
		result.include("usuarios", usuarios);
	}
}
