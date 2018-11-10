package br.com.maddytec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.maddytec.model.Venda;

public interface Vendas extends JpaRepository<Venda, Long> {

}
