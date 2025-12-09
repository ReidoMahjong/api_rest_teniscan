package com.example.teniscan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.teniscan.model.Feedback;
import com.example.teniscan.service.FeedbackService;

@RestController
@RequestMapping("/api/feedbacks")
public class FeedbackController {

    @Autowired
    private FeedbackService service;

    @GetMapping
    public List<Feedback> listar() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Feedback buscar(@PathVariable Integer id) {
        return service.findById(id).orElse(null);
    }

    @PostMapping
    public Feedback criar(@RequestBody Feedback feedback) {
        return service.save(feedback);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.delete(id);
    }
}