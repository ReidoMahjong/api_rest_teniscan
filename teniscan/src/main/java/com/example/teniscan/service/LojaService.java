package com.example.teniscan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teniscan.model.Loja;
import com.example.teniscan.repository.LojaRepository;

@Service
public class LojaService {

    @Autowired
    private LojaRepository repository;

    public List<Loja> findAll() {
        return repository.findAll();
    }

    public Loja findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Loja não encontrada"));
    }

    public Loja save(Loja obj) {
        return repository.save(obj);
    }

    public Loja update(int id, Loja obj) {
        Loja loja = findById(id);
        loja.setNome(obj.getNome());
        loja.setLogo(obj.getLogo());
        return repository.save(loja);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
