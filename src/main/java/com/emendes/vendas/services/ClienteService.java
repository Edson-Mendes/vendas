package com.emendes.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import com.emendes.vendas.dto.ClienteDTO;
import com.emendes.vendas.entities.Cliente;
import com.emendes.vendas.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService{

  @Autowired
  ClienteRepository clienteRepository;

  public List<ClienteDTO> findAll() {
    List<Cliente> res = clienteRepository.findAll();

    return res.stream().map(c -> new ClienteDTO(c)).collect(Collectors.toList());
  }
  
}
