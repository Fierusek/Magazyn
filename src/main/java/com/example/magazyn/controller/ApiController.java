package com.example.magazyn.controller;

import com.example.magazyn.model.entities.Order;
import com.example.magazyn.model.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ApiController {
    @Autowired
    public ApiController(ApiControllerHelper helper) {
        this.helper = helper;
    }
    ApiControllerHelper helper;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/products")
    public List<Product> products(){
        return helper.getProducts();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/orders")
    public List<Order> orders(){
        return helper.getOrders();
    }


}