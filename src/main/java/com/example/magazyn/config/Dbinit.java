package com.example.magazyn.config;

import com.example.magazyn.model.ProductType;
import com.example.magazyn.model.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class Dbinit {
    @Autowired
    public Dbinit(OrderRepo orderRepo, ProductRepo productRepo, EmployeeRepo empRepo, ClientRepo cr) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
        this.empRepo = empRepo;
        this.clientRepo = cr;
    }

    EmployeeRepo empRepo;
    ClientRepo clientRepo;
    OrderRepo orderRepo;
    ProductRepo productRepo;

    @PostConstruct
    public void init() {
        Set<Product> prods1 = new HashSet<>();
        Set<Product> prods2 = new HashSet<>();
        Set<Product> prods3 = new HashSet<>();
        Product prod1 = new Product("Woda Mineralna", ProductType.beverage, 5);
        Product prod2 = new Product("Grzeski", ProductType.food, 2);
        Product prod3 = new Product("Ziemniaki", ProductType.food, 20);
        Product prod4 = new Product("Papier toaletowy", ProductType.utility, 5);
        Product prod5 = new Product("Ogórki kiszone", ProductType.food, 3);
        Product prod6 = new Product("Arizona zielona", ProductType.beverage, 3);
        Product prod7 = new Product("Guma Orbit", ProductType.utility, 2);
        Product prod8 = new Product("Kurczak", ProductType.food, 10);
        Product prod9 = new Product("Super Glue", ProductType.utility, 3);
        Product prod10 = new Product("Wino", ProductType.beverage, 2);
        Order o1 = new Order(LocalDate.of(2020, 2, 10));
        Order o2 = new Order(LocalDate.of(2020, 7, 21));
        Order o3 = new Order(LocalDate.of(2020, 5, 3));
        Employee emp1 = new Employee("Imie", "Testowe", "ulica", "2b", "-", "00-000", "Miasto", 3500.00);
        Client cl1 = new Client("Imie2", "Testowe2", "ulica2", "3", "4a", "00-001", "Miasto1");
        Client cl2 = new Client("Imie3", "Testowe3", "ulica3", "4/2", "5", "00-002", "Miasto2");
        prods1.add(prod1);
        prods1.add(prod2);
        prods1.add(prod5);
        prods1.add(prod8);
        prods2.add(prod3);
        prods3.add(prod4);
        prods3.add(prod6);
        prods3.add(prod7);
        prods3.add(prod9);
        prods3.add(prod10);

        productRepo.save(prod1);
        productRepo.save(prod2);
        productRepo.save(prod3);
        productRepo.save(prod4);
        productRepo.save(prod5);
        productRepo.save(prod6);
        productRepo.save(prod7);
        productRepo.save(prod8);
        productRepo.save(prod9);
        productRepo.save(prod10);
        empRepo.save(emp1);
        clientRepo.save(cl1);
        clientRepo.save(cl2);
        orderRepo.save(o1);
        orderRepo.save(o2);
        orderRepo.save(o3);

        o1.setEmployee(empRepo.findAllById(emp1.getId()).get(0));
        o2.setEmployee(empRepo.findAllById(emp1.getId()).get(0));
        o3.setEmployee(empRepo.findAllById(emp1.getId()).get(0));
        o1.setClient(cl1);
        o2.setClient(cl1);
        o3.setClient(cl2);
        o1.setProducts(prods1);
        o2.setProducts(prods2);
        o3.setProducts(prods3);
        orderRepo.save(o1);
        orderRepo.save(o2);
        orderRepo.save(o3);


    }
}
