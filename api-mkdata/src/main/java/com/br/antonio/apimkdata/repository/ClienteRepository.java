package com.br.antonio.apimkdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.br.antonio.apimkdata.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{

}
