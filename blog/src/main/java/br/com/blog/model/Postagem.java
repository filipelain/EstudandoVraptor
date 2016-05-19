package br.com.blog.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Postagem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	private String postagem;
	@NotEmpty
	private String titulo;
	
	
	@Temporal(TemporalType.DATE)  
	private Calendar dataPost;
	
	@ManyToOne
	private Usuario usuario;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPostagem() {
		return postagem;
	}
	public void setPostagem(String postagem) {
		this.postagem = postagem;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Calendar getDataPost() {
		return dataPost;
	}
	public void setDataPost(Calendar dataPost) {
		this.dataPost = dataPost;
	}

}
