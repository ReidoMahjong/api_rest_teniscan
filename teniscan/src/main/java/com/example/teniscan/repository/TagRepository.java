package com.example.teniscan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.teniscan.model.Tag;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
