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
	public Postagem getpostagem(int id) {
		System.out.println("O lavor passado é: " + id);
		     TypedQuery<Postagem> query = manager.createQuery("select p from Postagem p where p.id =:id ", Postagem.class);
		      query.setParameter("id",id);
		  try {
			  return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}    
		
	}
	public List<Postagem> listaPorAutor(int id) {
		     TypedQuery<Postagem> query = manager.createQuery("select p from Postagem p where p.usuario.id =:autor ", Postagem.class);
		     query.setParameter("autor", id);
		return query.getResultList();
	}
	public void alteraPost(Postagem postagem) {
		manager.getTransaction().begin();
		manager.merge(postagem);
		manager.getTransaction().commit();
		
		
	}
	


}
