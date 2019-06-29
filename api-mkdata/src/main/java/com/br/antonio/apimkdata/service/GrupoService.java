package com.br.antonio.apimkdata.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.antonio.apimkdata.model.Grupo;
import com.br.antonio.apimkdata.repository.GrupoRepository;

@Service
public class GrupoService {
	
	@Autowired
	GrupoRepository dao;
	
	public List<Grupo> findAll() {
		return dao.findAll();
	}
	
	public Grupo saveGrupo(Grupo grupo) {
		return dao.save(grupo);
	}

}
