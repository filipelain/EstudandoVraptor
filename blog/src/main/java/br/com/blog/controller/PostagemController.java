package br.com.blog.controller;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.blog.DAO.PostagemDao;
import br.com.blog.model.Postagem;
import br.com.blog.securit.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;


@Controller
public class PostagemController {

	
  

	private PostagemDao dao;
	private Validator validator;
	private Result result;
	private UsuarioLogado logado;

	@Inject
	public PostagemController(PostagemDao dao, Validator validator, Result result, UsuarioLogado logado) {
		this.dao = dao;
		this.validator = validator;
		this.result = result;
		this.logado = logado;
	}

	public PostagemController() {
	}

	public void form() {
	}

	public void novaPostagem(@Valid Postagem postagem) {
		validator.onErrorRedirectTo(this).form();
		postagem.setUsuario(logado.getUsuario());
		postagem.setDataPost(Calendar.getInstance());
		dao.novoPost(postagem);  
		result.redirectTo(this).lista();
	}

	public void lista() {
		List<Postagem> postagems = dao.ListPost();
		result.include("postagems", postagems);
	}

}
