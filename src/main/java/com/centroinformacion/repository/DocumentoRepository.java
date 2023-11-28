package com.centroinformacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.centroinformacion.entity.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Integer>{

}
