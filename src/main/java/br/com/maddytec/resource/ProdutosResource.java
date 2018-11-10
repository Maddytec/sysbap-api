package br.com.maddytec.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.maddytec.model.Produto;
import br.com.maddytec.repository.Produtos;
import br.com.maddytec.service.ProdutoService;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/produtos")
public class ProdutosResource {
	
	@Autowired
	private Produtos produtos;
	
	@Autowired
	ProdutoService produtoService;

	@GetMapping
	public List<Produto> findAll(){
		return produtos.findAll();
	}
	
	@PostMapping
	public Produto adicionar(@RequestBody @Valid Produto produto) {
		return produtoService.adicionar(produto);
	}
	
	@GetMapping("/{id}")
	public Produto findById(@PathVariable Long id) {
		return produtos.findById(id).orElse(null);
	}
	
}

