package com.example.magazyn.controller;

import com.example.magazyn.model.entities.Order;
import com.example.magazyn.model.entities.OrderRepo;
import com.example.magazyn.model.entities.Product;
import com.example.magazyn.model.entities.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApiControllerHelper {
    @Autowired
    public ApiControllerHelper(ProductRepo products, OrderRepo orders) {
        this.products = products;
        this.orders = orders;
    }
    ProductRepo products;
    OrderRepo orders;

    public List<Product> getProducts(){
        System.out.println("In Controller");
        System.out.println("Find all: " + products.findAll());
        return products.findAll();
    }

    public List<Order> getOrders(){
        System.out.println("In Controller");
        System.out.println("Find all: " + products.findAll());
        return orders.findAll();
    }
}
