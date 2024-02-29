        package com.example.springapphasc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.example.springapphasc.model.Customer;
import com.example.springapphasc.repository.CustomerRepo;

@Service
public class CustomerService {
    @Autowired
    CustomerRepo customerRepo;

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    public Customer getCustomer(int customerId){
        return customerRepo.findById(customerId).orElse(null);
    }

    public Customer postCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public Customer updateCustomer(int customerId, Customer newCustomer){
        Customer customer = getCustomer(customerId);
        if(customer != null){
            customer.setCustomerId(newCustomer.getCustomerId());
            customer.setCustomerName(newCustomer.getCustomerName());
            customer.setEmail(newCustomer.getEmail());
            customer.setPassword(newCustomer.getEmail());
            customer.setPhoneNo(newCustomer.getPhoneNo());
            customer.setEventRequest(newCustomer.getEventRequest());
            return customerRepo.save(customer);
        }
        return null;
    }

    public boolean deleteCustomer(int customerId){
        Customer customer = getCustomer(customerId);
        if(customer != null){
            customerRepo.delete(customer);
            return true;
        }
        return false;
    }

    public Page<Customer> getPaginated(int number, int pageSize, String field){
        return customerRepo.findAll(PageRequest.of(number, pageSize, Sort.by(field)));
    }


    
}
