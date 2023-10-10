package com.javatechie.report.controller;

import com.javatechie.report.entity.Employee;
import com.javatechie.report.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BanglaController {

    @Autowired
    EmployeeRepository repository;


    @PostMapping("/send-bengali-text")
    public String receiveBengaliText(@RequestParam("bengaliText") String bengaliText) {
        // Here you can process the Bengali text as needed
        System.out.println("bengaliText = " + bengaliText);
        Employee employee = new Employee();
        employee.setName(bengaliText);
        repository.save(employee);
        return "Received: " + bengaliText;
    }
}
