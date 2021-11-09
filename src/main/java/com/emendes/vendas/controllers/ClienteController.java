package com.emendes.vendas.controllers;

import java.util.List;

import com.emendes.vendas.dto.ClienteDTO;
import com.emendes.vendas.services.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
  public ResponseEntity<List<ClienteDTO>> findAll() {
    List<ClienteDTO> lista = clienteService.findAll();
    return ResponseEntity.ok(lista);
  }

}
