package br.com.blog.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	private Result result;
	private UsuarioController usuarioController;

	
	
	@Inject
	public IndexController(Result result, UsuarioController usuarioController) {
		this.result = result;
		this.usuarioController = usuarioController;
	}
	public IndexController() {}

	@Path("/")
	public void index() {
		usuarioController.ulista();
	}
}