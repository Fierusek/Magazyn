package com.example.magazyn.model.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface ProductRepo extends JpaRepository<Product, Long> {
    List<Product> findAll();

}
