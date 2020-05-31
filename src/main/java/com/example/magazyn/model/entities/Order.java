package com.example.magazyn.model.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name="orders")
public class Order {
    public Order() {
    }

    public Order(LocalDate date) {
        this.dateRealised = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="order_id")
    @Getter
    @Setter
    private Long id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "order_product",
            joinColumns =
            @JoinColumn(name = "order_id"),
            inverseJoinColumns =
            @JoinColumn(name = "product_id"))
    private Set<Product> products;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "order_employee",
            joinColumns =
            @JoinColumn(name = "order_id"),
            inverseJoinColumns =
            @JoinColumn(name = "empl_id"))
    private Employee employee;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "order_client",
            joinColumns =
            @JoinColumn(name = "order_id"),
            inverseJoinColumns =
            @JoinColumn(name = "client_id"))
    private Client client;

    private LocalDate dateRealised;

}
