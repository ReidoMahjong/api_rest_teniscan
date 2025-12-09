package com.example.teniscan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teniscan.model.Tenis;
import com.example.teniscan.repository.TenisRepository;

@Service
public class TenisService {

    @Autowired
    private TenisRepository repository;

    public List<Tenis> findAll() {
        return repository.findAll();
    }

    public Optional<Tenis> findById(Integer id) {
        return repository.findById(id);
    }

    public Tenis save(Tenis tenis) {
        return repository.save(tenis);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Tenis> findByTags(int uso, int pe, int pisada, int genero){
        return repository.findByUsoIdAndPeIdAndPisadaIdAndGeneroId(uso, pe, pisada, genero);
    }
}