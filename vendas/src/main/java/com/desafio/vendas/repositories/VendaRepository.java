package com.desafio.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desafio.vendas.entities.Venda;


@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

}
