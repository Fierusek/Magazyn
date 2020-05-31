package com.example.magazyn.model;

import com.example.magazyn.model.entities.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

//Reprezentuje miejsca w magazynie
public class Slot {
    @Getter @Setter private Long id;
    @Getter @Setter int capacity;
    @Getter @Setter List<Product> products;
}
