package com.br.antonio.apimkdata.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.br.antonio.apimkdata.handlerExceptions.CustomException;
import com.br.antonio.apimkdata.model.Cliente;
import com.br.antonio.apimkdata.repository.ClienteRepository;

@Service
public class ClienteService {
	
	
	@Autowired
	ClienteRepository dao;
	
	public Optional<Cliente> getCliente(Integer id) {
		return dao.findById(id);
	}
	
	public List<Cliente> getAllClientes(){
		return dao.findAll();
	}
	
	public Cliente saveCliente(Cliente cliente) throws CustomException {
		if(cliente.getTipo().equals("F")) {
			if(StringUtils.isEmpty(cliente.getCpf())) {
				throw new CustomException("400","Campo CPF Obrigatorio");
			}
		}else {
			if(StringUtils.isEmpty(cliente.getCnpj())) {
				throw new CustomException("400","Campo CNPJ Obrigatorio");
			}
		}
		return dao.save(cliente);
		
	}

}
