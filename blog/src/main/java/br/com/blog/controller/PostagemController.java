package br.com.blog.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

	public void novapostagem(@Valid Postagem postagem) {
		validator.onErrorRedirectTo(this).form();
		postagem.setUsuario(logado.getUsuario());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		String d = dateFormat.format(new Date());
		try {
			c.setTime(dateFormat.parse((d)));
		} catch (Exception e) {}
		postagem.setDataPost(c);
		dao.novoPost(postagem);  
		result.redirectTo(this).lista();
	}

	public void lista() {
		List<Postagem> postagems = dao.ListPost();
		result.include("postagems", postagems);
	}

}
