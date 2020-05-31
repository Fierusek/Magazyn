package com.example.magazyn.model.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface OrderRepo extends JpaRepository<Order, Long> {
    List<Order> findAll();
    List<Order> findAllById(Long id);

}
