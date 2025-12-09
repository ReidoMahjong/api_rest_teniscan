package com.example.teniscan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "feedbacks")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer nota;

    @ManyToOne
    @JoinColumn(name = "uso_id", nullable = false)
    private Tag uso;

    @ManyToOne
    @JoinColumn(name = "pe_id", nullable = false)
    private Tag pe;

    @ManyToOne
    @JoinColumn(name = "pisada_id", nullable = false)
    private Tag pisada;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    private Tag genero;
}