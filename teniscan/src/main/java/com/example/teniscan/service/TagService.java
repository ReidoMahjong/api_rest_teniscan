package com.example.teniscan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teniscan.model.Tag;
import com.example.teniscan.repository.TagRepository;

@Service
public class TagService {

    @Autowired
    private TagRepository repository;

    public List<Tag> findAll() {
        return repository.findAll();
    }

    public Optional<Tag> findById(Integer id) {
        return repository.findById(id);
    }

    public Tag save(Tag tag) {
        return repository.save(tag);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
