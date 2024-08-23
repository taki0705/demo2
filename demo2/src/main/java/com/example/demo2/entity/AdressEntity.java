package com.example.demo2.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class AdressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(nullable = false)
    private  String Street;
    @Column(nullable = false)
    private String Housenumber;
    @Column(nullable = false)
    private String zipCode;
}
