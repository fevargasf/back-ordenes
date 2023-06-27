package com.example.ordenes.repository;

import com.example.ordenes.model.pojo.DetalleOrdenEntity;
import com.example.ordenes.model.pojo.OrdenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DetalleOrdenRepository extends JpaRepository<DetalleOrdenEntity, Integer> {



}
