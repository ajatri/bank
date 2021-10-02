package com.thbs.dhandhan.controller;


import com.thbs.dhandhan.data.entity.Customer;
import com.thbs.dhandhan.data.repo.CustomerRepo;
import com.thbs.dhandhan.data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerRepo customerRepo;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id) {
        return customerService.getCustomer(id);
    }

    @PostMapping("/customers")
    public Integer addCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

    @PostMapping("/customers/register")
    public Integer registerCustomer(@RequestBody Customer customer) {
        return customerService.registerCustomer(customer);
    }

    @PostMapping("customers/login")

    public boolean loginCustomer(@RequestBody(required = true) Customer customer) {
        return customerService.loginCustomer(customer.getCustomerId(), customer.getPassword());
    }

    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {
       return  updateCustomer( customer);
    }

    @DeleteMapping("/customers/{id}")
    public void deleteCustomer(@PathVariable("id") Integer id) {
        customerRepo.deleteById(id);
    }


}
