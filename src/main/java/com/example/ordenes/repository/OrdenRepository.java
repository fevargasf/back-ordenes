package com.example.ordenes.repository;

import com.example.ordenes.model.pojo.OrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenEntity, Integer> {



}
