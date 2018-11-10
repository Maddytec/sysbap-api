package br.com.maddytec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maddytec.model.Produto;

public interface Produtos extends JpaRepository<Produto, Long> {

}
