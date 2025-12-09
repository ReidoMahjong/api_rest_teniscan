package com.example.teniscan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teniscan.model.Tag;
import com.example.teniscan.service.TagService;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService service;

    @GetMapping
    public List<Tag> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Tag buscar(@PathVariable Integer id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Tag criar(@RequestBody Tag tag) {
        return service.save(tag);
    }

    @PutMapping("/{id}")
    public Tag atualizar(@PathVariable Integer id, @RequestBody Tag tag) {
        tag.setId(id);
        return service.save(tag);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.delete(id);
    }
}