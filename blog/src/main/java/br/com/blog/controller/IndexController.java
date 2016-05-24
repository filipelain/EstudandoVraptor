package br.com.blog.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.blog.DAO.PostagemDao;
import br.com.blog.model.Postagem;
import br.com.blog.securit.Open;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class IndexController {

	private Result result;
	private PostagemDao dao;

	@Inject
	public IndexController(Result result, PostagemDao dao) {
		this.result = result;
		this.dao = dao;
	}

	public IndexController() {

	}

	@Open
	@Path("/")
	public void index() {
		List<Postagem> postagens = dao.ListPost();
		result.include("postagens", postagens);
	}
}