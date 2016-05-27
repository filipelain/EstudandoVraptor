package br.com.blog.interfaces;

import java.net.URI;

import br.com.blog.model.Arquivo;

public interface Diretorio {

	URI grava(Arquivo arquivo);
	Arquivo recupera( URI chave);
}
