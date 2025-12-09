package com.example.teniscan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teniscan.model.Marca;
import com.example.teniscan.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository repository;

    public List<Marca> findAll() {
        return repository.findAll();
    }

    public Marca findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Marca não encontrada"));
    }

    public Marca save(Marca obj) {
        return repository.save(obj);
    }

    public Marca update(int id, Marca obj) {
        Marca marca = findById(id);
        marca.setNome(obj.getNome());
        marca.setLogo(obj.getLogo());
        return repository.save(marca);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}