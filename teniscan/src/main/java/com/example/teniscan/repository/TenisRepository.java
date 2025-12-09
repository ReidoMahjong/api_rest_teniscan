package com.example.teniscan.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teniscan.model.Tenis;

public interface TenisRepository extends JpaRepository<Tenis, Integer> {
    List<Tenis> findByUsoIdAndPeIdAndPisadaIdAndGeneroId(Integer uso, Integer pe, Integer pisada, Integer genero);
}
