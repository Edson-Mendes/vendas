package com.emendes.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import com.emendes.vendas.dto.ComprasDTO;
import com.emendes.vendas.dto.RankingComprasDTO;
import com.emendes.vendas.entities.Cliente;
import com.emendes.vendas.entities.Compras;
import com.emendes.vendas.repositories.ClienteRepository;
import com.emendes.vendas.repositories.ComprasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ComprasService {
  @Autowired
  ComprasRepository comprasRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  public List<ComprasDTO> findAll() {
    clienteRepository.findAll();
    List<Compras> res = comprasRepository.findAll();

    return res.stream().map(c -> new ComprasDTO(c)).collect(Collectors.toList());
  }

  public Compras saveCompras(Compras compras) {
    return comprasRepository.save(compras);
  }

  public Compras updateCompras(Integer id, Compras newCompras) {
    return comprasRepository.findById(id).map(compras -> {
      compras.setTotalCompra(newCompras.getTotalCompra());
      compras.setDataCompra(newCompras.getDataCompra());
      Compras atualizado = comprasRepository.save(compras);
      return atualizado;
    }).orElse(null);
  }

  public void deleteCompras(Integer id) {
    try {
      if (comprasRepository.findById(id) != null) {
        comprasRepository.deleteById(id);
      }
    } catch (DataIntegrityViolationException e) {
      throw new DataIntegrityViolationException("Você não pode deletar um cliente que fez compras!");
    }
  }

  public List<RankingComprasDTO> findRanking(){
    List<RankingComprasDTO> resp = comprasRepository.findRanking();
    return resp;
  }

  public Compras fromDTO(ComprasDTO comprasDTO) {
    Compras entidade = new Compras(0, comprasDTO.getTotalCompra(), comprasDTO.getDataCompra(),
        new Cliente(comprasDTO.getCliente().getId(), null, null));
    return entidade;
  }

}
