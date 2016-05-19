package br.com.blog.DAO;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.blog.model.Postagem;

@RequestScoped
public class PostagemDao {

	private EntityManager manager;


	@Inject
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
	 TypedQuery<Postagem> query = manager.createQuery("select p from Postagem p",Postagem.class);
	 return query.getResultList();
	}
	


}
