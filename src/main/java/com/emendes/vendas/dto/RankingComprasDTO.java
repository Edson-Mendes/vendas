package com.emendes.vendas.dto;

import com.emendes.vendas.entities.Cliente;

public class RankingComprasDTO {
  private String nome;
  private Double valorTotal;

  public RankingComprasDTO(){}

  public RankingComprasDTO(Cliente cliente, Double valorTotal){
   this.nome = cliente.getNome();
   this.valorTotal = valorTotal; 
  }

  public String getNomeCliente() {
    return nome;
  }

  public void setNomeCliente(String nomeCliente) {
    this.nome = nomeCliente;
  }

  public Double getValorTotal() {
    return valorTotal;
  }

  public void setValorTotal(Double valorTotal) {
    this.valorTotal = valorTotal;
  }

}
