package br.com.blog.DAO;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import br.com.blog.model.Usuario;

public class UsuarioDAO {
	
	
	private EntityManager manager;


	@Inject
	public UsuarioDAO( EntityManager manager) {
		this.manager = manager;
	}
	
	public UsuarioDAO() {
	}

	public List<Usuario> lista() {
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u ",Usuario.class);
		return query.getResultList();
	}

	public void novo(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
	}

	@SuppressWarnings("unused")
	public Usuario busca(String nome, String senha) {
	    TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u  "
	    		+ " where u.nome =:nome and u.senha =:senha ", Usuario.class);
	    query.setParameter("nome", nome);
	    query.setParameter("senha", senha);
	    System.out.println("nome: "+nome+"/n Senha:"+senha);
	    if (query == null) {
			return null;
		}
		  try {
			  return query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
		
	}
	
	
	


}
