package com.example.demo2.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "department")
    private List<EmployeeEntity> employeess;
}
