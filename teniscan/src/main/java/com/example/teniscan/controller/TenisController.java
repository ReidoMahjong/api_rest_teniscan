package com.example.teniscan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.teniscan.model.Tenis;
import com.example.teniscan.service.TenisService;

@RestController
@RequestMapping("/api/tenis")
@CrossOrigin(origins = "https://seusite.com")
public class TenisController {

    @Autowired
    private TenisService service;

    @GetMapping
    public List<Tenis> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Tenis buscar(@PathVariable Integer id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Tenis criar(@RequestBody Tenis tenis) {
        return service.save(tenis);
    }

    @PutMapping("/{id}")
    public Tenis atualizar(@PathVariable Integer id, @RequestBody Tenis tenis) {
        tenis.setId(id);
        return service.save(tenis);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.delete(id);
    }

    @GetMapping("/filter")
    public List<Tenis> filtrar(
        @RequestParam Integer uso,
        @RequestParam Integer pe,
        @RequestParam Integer pisada
    ) {
        return service.findByTags(uso, pe, pisada);
    }

}