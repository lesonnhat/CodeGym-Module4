package com.codegym.springbootproductmanagement.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Double quantity;
    private String imageUrl;
}