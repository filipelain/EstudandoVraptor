package br.com.blog.controller;

import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.apache.taglibs.standard.tag.common.xml.IfTag;
import org.hamcrest.core.IsNull;

import com.google.common.io.ByteStreams;

import br.com.blog.DAO.PostagemDao;
import br.com.blog.interfaces.Diretorio;
import br.com.blog.model.Arquivo;
import br.com.blog.model.Postagem;
import br.com.blog.securit.Open;
import br.com.blog.securit.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.observer.download.ByteArrayDownload;
import br.com.caelum.vraptor.observer.download.Download;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PostagemController {

	private PostagemDao dao;
	private Validator validator;
	private Result result;
	private UsuarioLogado logado;
	private Diretorio imagem;

	@Inject
	public PostagemController(PostagemDao dao, Diretorio imagem, Validator validator, Result result,
			UsuarioLogado logado) {
		this.dao = dao;
		this.imagem = imagem;
		this.validator = validator;
		this.result = result;
		this.logado = logado;
	}

	public PostagemController() {
	}

	public void form() {
	}

	public void editform(int id) {

		Postagem postagem = dao.getpostagem(id);
		result.include(postagem);
	}

	@IncludeParameters
	@Transactional
	public void editapostagem(@Valid Postagem postagem, UploadedFile capa) {
		try {
			if (imagem != null) {
				URI Postimagem = imagem.grava(new Arquivo(capa.getFileName(), ByteStreams.toByteArray(capa.getFile()),
						capa.getContentType(), Calendar.getInstance()));
				postagem.setCapa(Postimagem);
			}

		} catch (IOException e) {
		
			e.printStackTrace();
		} 
		
		int id = postagem.getId();
		postagem.setUsuario(logado.getUsuario());
		validator.onErrorRedirectTo(this).editform(id);
		dao.alteraPost(postagem);
		result.redirectTo(this).exibepostagem(id);

	}

	@IncludeParameters @Transactional
	public void novapostagem(@Valid Postagem postagem, UploadedFile capa) {
		try {
			if (imagem != null) {
				URI Postimagem = imagem.grava(new Arquivo(capa.getFileName(), ByteStreams.toByteArray(capa.getFile()),
						capa.getContentType(), Calendar.getInstance()));
				postagem.setCapa(Postimagem);
			}

		} catch (IOException e) {
		
			e.printStackTrace();
		}
		validator.onErrorRedirectTo(this).form();
		postagem.setUsuario(logado.getUsuario());
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		String d = dateFormat.format(new Date());
		try {
			c.setTime(dateFormat.parse((d)));
		} catch (Exception e) {
		}
		postagem.setDataPost(c);
		dao.novoPost(postagem);
		result.redirectTo(this).lista();
	}
	@Open
	public void lista() {
		List<Postagem> postagens = dao.ListPost();
		result.include("postagens", postagens);
	}

	@Open
	public void listaporautor(int id) {
		List<Postagem> postagens = dao.listaPorAutor(id);
		result.include("postagens", postagens);
	}

	@Open
	public void exibepostagem(int id) {
		Postagem postagem = dao.getpostagem(id);
		result.include(postagem);
	}
	@Open
	public Download capa(int id)
	{
		
		Postagem postagem = dao.getpostagem(id);
		Arquivo capa = imagem.recupera(postagem.getCapa());
		if( capa == null )
		{
			result.notFound();
			return null;
		}
		return new ByteArrayDownload(capa.getConteudo(), capa.getTipo(), capa.getNome());
	}

}
