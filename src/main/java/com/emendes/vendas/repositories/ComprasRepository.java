package com.emendes.vendas.repositories;

import java.util.List;

import com.emendes.vendas.dto.RankingComprasDTO;
import com.emendes.vendas.entities.Compras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ComprasRepository extends JpaRepository<Compras, Integer>{
  
  @Query("SELECT new com.emendes.vendas.dto.RankingComprasDTO(compras.cliente, SUM(compras.totalCompra)) FROM Compras AS compras GROUP BY compras.cliente ORDER BY SUM(compras.totalCompra) DESC")
  List<RankingComprasDTO> findRanking();

}
