package br.com.blog.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.blog.model.Postagem;

public class PostagemDao {

	private EntityManager manager;



	public PostagemDao( EntityManager manager) {
		this.manager = manager;
	}
	public PostagemDao() {
		
	}
	
	
	
	public void novoPost(Postagem postagem) {
		manager.getTransaction().begin();
		manager.persist(postagem);
		manager.getTransaction().commit();
	}



	public List<Postagem> ListPost() {
	 TypedQuery<Postagem> query = manager.createQuery("select p form Postagem p",Postagem.class);
	 return query.getResultList();
	}
	


}
