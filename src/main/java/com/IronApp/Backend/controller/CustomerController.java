package com.IronApp.Backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.IronApp.Backend.model.Customer;
import com.IronApp.Backend.repository.CustomerRepository;

@Controller
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/form")
    public String showForm(Customer customer) {
        return "form";
    }

    @PostMapping("/form")
    public String processForm(Customer customer) {
        customerRepository.save(customer);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccess() {
        return "success";
    }
}
