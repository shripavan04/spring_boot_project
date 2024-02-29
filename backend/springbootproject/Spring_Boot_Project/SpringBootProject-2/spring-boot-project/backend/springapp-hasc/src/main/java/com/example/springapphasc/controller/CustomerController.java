package com.example.springapphasc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.example.springapphasc.model.Customer;
import com.example.springapphasc.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/events")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/getCustomers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();
    }

    @GetMapping("/get")
    public Customer getCustomer(@RequestParam("cid") int customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping("/post")
    public Customer postCustomer(@RequestBody Customer customer) {
        return customerService.postCustomer(customer);
    }

    @PutMapping("/updateCustomer")
    public Customer updateCustomer(@RequestParam("cid") int customerId, @RequestBody Customer newCustomer) {
        return customerService.updateCustomer(customerId, newCustomer);
    }

    @DeleteMapping("/deleteCustomer")
    public boolean deleteCustomer(@RequestParam("cid") int customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @GetMapping("/getPaginated")
    public Page<Customer> getPaginated(@RequestParam int number, @RequestParam int pageSize,
            @RequestParam String field) {
        return customerService.getPaginated(number, pageSize, field);
    }

}
