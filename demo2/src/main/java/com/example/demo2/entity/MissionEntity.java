package com.example.demo2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class MissionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String period;
    @ManyToMany(mappedBy = "missions")
    private List<EmployeeEntity> employees;
}
