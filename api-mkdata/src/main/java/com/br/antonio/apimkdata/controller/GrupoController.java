package com.br.antonio.apimkdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.antonio.apimkdata.model.Grupo;
import com.br.antonio.apimkdata.service.GrupoService;

@RestController
@RequestMapping("/grupo")
public class GrupoController {
	
	@Autowired
	GrupoService service;
	
	@GetMapping
	public ResponseEntity<?> listarGrupos(){
		return new ResponseEntity<List<Grupo>>(service.findAll(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> adicionarGrupo(@RequestBody Grupo grupo){
		return new ResponseEntity<Grupo>(service.saveGrupo(grupo),HttpStatus.OK);
	}

}
