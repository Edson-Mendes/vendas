package com.emendes.vendas.repositories;

import com.emendes.vendas.entities.Compras;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprasRepository extends JpaRepository<Compras, Integer>{
  
}
