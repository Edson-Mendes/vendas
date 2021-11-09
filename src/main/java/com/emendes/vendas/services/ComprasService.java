package com.emendes.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import com.emendes.vendas.dto.ComprasDTO;
import com.emendes.vendas.entities.Compras;
import com.emendes.vendas.repositories.ComprasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComprasService {
  @Autowired
  ComprasRepository clienteRepository;

  public List<ComprasDTO> findAll() {
    List<Compras> res = clienteRepository.findAll();

    return res.stream().map(c -> new ComprasDTO(c)).collect(Collectors.toList());
  }
}
