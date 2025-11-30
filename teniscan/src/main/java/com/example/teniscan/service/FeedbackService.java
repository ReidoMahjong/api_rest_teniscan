package com.example.teniscan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.teniscan.model.Feedback;
import com.example.teniscan.repository.FeedbackRepository;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    public List<Feedback> findAll() {
        return repository.findAll();
    }

    public Optional<Feedback> findById(Integer id) {
        return repository.findById(id);
    }

    public Feedback save(Feedback feedback) {
        return repository.save(feedback);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}