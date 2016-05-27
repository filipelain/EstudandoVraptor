package br.com.blog.interfaces;

import java.net.URI;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.blog.model.Arquivo;

public class DiretorioNoDB implements Diretorio {

	private EntityManager manager;

	@Inject
	public DiretorioNoDB(EntityManager manager) {
		this.manager = manager;

	}

	@Deprecated
	public DiretorioNoDB() {
	}

	@Override
	public URI grava(Arquivo arquivo) {
		manager.getTransaction().begin();
		manager.persist(arquivo);
		manager.getTransaction().commit();
		return URI.create("bd://" + arquivo.getId());
	}

	@Override
	public Arquivo recupera(URI chave) {
		if (chave == null)
			return null;

		if (!chave.getScheme().equals("bd")) {
			throw new IllegalArgumentException(chave + " Não é uma URI do Banco de Dados");
		}
		Integer id = Integer.valueOf(chave.getAuthority());
		return manager.find(Arquivo.class, id);
		
	}

}
