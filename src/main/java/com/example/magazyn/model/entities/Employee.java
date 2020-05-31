package com.example.magazyn.model.entities;

import lombok.*;


import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    public Employee() {
    }

    public Employee(String name, String surename, String street, String streetNo, String flatNo, String postcode, String city, double pay) {
        this.name = name;
        this.surename = surename;
        this.street = street;
        this.postcode = postcode;
        this.streetNo = streetNo;
        this.city = city;
        this.flatNo = flatNo;
        this.payment = pay;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "empl_id")
    @Getter @Setter private Long id;
    @Getter @Setter private String name;
    @Getter @Setter private String surename;
    @Getter @Setter private String street;
    @Getter @Setter private String streetNo;
    @Getter @Setter private String flatNo;
    @Getter @Setter private String postcode;
    @Getter @Setter private String city;
    @Getter @Setter private double payment;
}
