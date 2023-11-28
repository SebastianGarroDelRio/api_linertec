package com.centroinformacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.centroinformacion.entity.Ubigeo;

@Repository
public interface UbigeoRepository extends JpaRepository<Ubigeo, Integer> {

}
