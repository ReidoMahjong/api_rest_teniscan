package com.example.teniscan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teniscan.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}