package com.example.magazyn.controller;

import com.example.magazyn.model.entities.Employee;
import com.example.magazyn.model.entities.EmployeeRepo;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginControllerHelper {
    @Autowired
    public LoginControllerHelper(Security sec, EmployeeRepo emps) {
        this.sec = sec;
        this.emps = emps;
    }

    Security sec;
    EmployeeRepo emps;

    public String authorize(String json) {
        boolean verified = false;
        JSONObject jsonO = new JSONObject(json);
        String username = jsonO.getString("username");
        String pass = jsonO.getString("password");
        System.out.println("vars: " + username + pass);

        try {
            Employee emp = emps.findAllByName(username).get(0);
            Employee emp2 = emps.findAllBySurename(pass).get(0);
            if (emp.getName().equals(emp2.getName()) && emp.getSurename().equals(emp2.getSurename())) verified = true;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("{token: 'invalid_login'}");
        }
        JSONObject returnJson = new JSONObject();

        if (verified) {
            System.out.println("{'token': '" + sec.getToken() + "'}");
            returnJson.put("token", sec.getToken());

        } else {
            System.out.println("{'token': 'invalid_login'}");
            returnJson.put("token", "invalid");
        }
        return returnJson.toString();
    }
}



