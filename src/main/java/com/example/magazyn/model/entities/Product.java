package com.example.magazyn.model.entities;

import com.example.magazyn.model.ProductType;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="products")
public class Product {
    public Product() {
    }

    public Product(String name, ProductType pt, int packegeSize) {
        this.name = name;
        this.productType = pt;
        this.packegeSize = packegeSize;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="product_id")
    private Long id;
    private String name;
    private ProductType productType;
    private int packegeSize;
}
