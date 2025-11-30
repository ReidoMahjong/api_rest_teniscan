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
@Table(name = "tenis")
public class Tenis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(nullable = false, length = 200)
    private String marca;

    @Column(nullable = false, length = 500)
    private String img;

    @Column(nullable = false, length = 1000)
    private String link;

    @ManyToOne
    @JoinColumn(name = "uso_id", nullable = false)
    private Tag uso;

    @ManyToOne
    @JoinColumn(name = "pe_id", nullable = false)
    private Tag pe;

    @ManyToOne
    @JoinColumn(name = "pisada_id", nullable = false)
    private Tag pisada;
}