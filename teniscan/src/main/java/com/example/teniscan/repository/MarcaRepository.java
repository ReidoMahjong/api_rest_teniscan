package com.example.teniscan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teniscan.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Integer> { }