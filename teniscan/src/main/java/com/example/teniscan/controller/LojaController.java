package com.example.teniscan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.teniscan.model.Loja;
import com.example.teniscan.service.LojaService;

@RestController
@RequestMapping("/api/lojas")
public class LojaController {

    @Autowired
    private LojaService service;

    @GetMapping
    public List<Loja> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Loja findById(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Loja save(@RequestBody Loja obj) {
        return service.save(obj);
    }

    @PutMapping("/{id}")
    public Loja update(@PathVariable int id, @RequestBody Loja obj) {
        return service.update(id, obj);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}