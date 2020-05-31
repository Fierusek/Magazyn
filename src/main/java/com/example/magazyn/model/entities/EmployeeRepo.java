package com.example.magazyn.model.entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findAll();
    List<Employee> findAllById(Long id);
    List<Employee> findAllByName(String name);
    List<Employee> findAllBySurename(String surename);
}
