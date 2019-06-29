package com.br.antonio.apimkdata.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.antonio.apimkdata.handlerExceptions.CustomException;
import com.br.antonio.apimkdata.handlerExceptions.ErrorResponse;
import com.br.antonio.apimkdata.model.Cliente;
import com.br.antonio.apimkdata.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCliente(@PathVariable("id")Integer id){
		return new ResponseEntity<Optional<Cliente>>(service.getCliente(id),HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<?> listarClientes(){
		return new ResponseEntity<List<Cliente>>(service.getAllClientes(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente){
		
		try {
			return new ResponseEntity<Cliente>(service.saveCliente(cliente),HttpStatus.OK);
		} catch (CustomException e) {
			return new ResponseEntity<ErrorResponse>(new ErrorResponse(e.getError(),e.getMessage()),HttpStatus.BAD_REQUEST);
		}
		
	}

}
