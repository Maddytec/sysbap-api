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

import br.com.maddytec.model.Cliente;
import br.com.maddytec.repository.Clientes;

@CrossOrigin(origins ="*")
@RestController
@RequestMapping("/clientes")
public class ClientesResource {

	@Autowired
	private Clientes clientes;
	
	@GetMapping
	public List<Cliente> listar(){
		return clientes.findAll();
	}
	
	@GetMapping("/{id}")
	public Cliente findById(@PathVariable @Valid Long id) {
		return clientes.findById(id).orElse(null);
	}
	
	@PostMapping
	public Cliente adicionar(@RequestBody @Valid Cliente cliente) {
		return clientes.save(cliente);
	}
}
