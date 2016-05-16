package br.com.blog.controller;

import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import javax.validation.Valid;

import com.mysql.fabric.xmlrpc.base.Data;

import br.com.blog.DAO.PostagemDao;
import br.com.blog.model.Postagem;
import br.com.blog.model.Usuario;
import br.com.blog.securit.UsuarioLogado;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PostagemController {

	private PostagemDao dao;
	private Result result;
	private UsuarioLogado usuarioLogado;
	private Validator validator;
	private UsuarioLogado logado;

	@Inject
	public PostagemController(UsuarioLogado logado, Result result, Validator validator) {
		logado = usuarioLogado;
		this.result = result;
		this.validator = validator;

	}

	public PostagemController() {
	}

	public void form() {
	}

	public void NovoPost(@Valid Postagem postagem) {
		validator.onErrorRedirectTo(this).form();
		postagem.setDataPost(Calendar.getInstance());
		postagem.setUsuario(usuarioLogado.getUsuario());
		dao.novoPost(postagem);
		result.redirectTo(IndexController.class).index();

	}

	public void lista() {
		List<Postagem> postagem = dao.ListPost();
		result.include("postagem", postagem);
	}

	@Path("/plista")
	public void ListPost() {
		List<Postagem> postagem = dao.ListPost();
		result.include("postagem", postagem);
	}

}
