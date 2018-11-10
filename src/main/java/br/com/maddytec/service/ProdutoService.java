package br.com.maddytec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.maddytec.model.Produto;
import br.com.maddytec.repository.Produtos;

@Service
public class ProdutoService {
	
	@Autowired
	Produtos produtos;
	
	public Produto adicionar(Produto produto) {
		return produtos.save(produto);
	}

}
