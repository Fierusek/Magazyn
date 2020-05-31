package com.example.magazyn.model;

import com.example.magazyn.model.entities.Employee;
import com.example.magazyn.model.entities.Order;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    Map<Integer, Slot> warehouseSlots = new HashMap<>();
    Map<Integer, Employee> activeEmployees = new HashMap<>();
    Map<Integer, Order> todayOrders = new HashMap<>();
}
