package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Task {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @ManyToOne
    private User user;
}

