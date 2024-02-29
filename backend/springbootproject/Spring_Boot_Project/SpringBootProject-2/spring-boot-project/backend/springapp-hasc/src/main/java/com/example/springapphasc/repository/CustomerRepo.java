package com.example.springapphasc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springapphasc.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
    
}
