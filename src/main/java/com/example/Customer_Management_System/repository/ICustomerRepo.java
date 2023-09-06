package com.example.Customer_Management_System.repository;

import com.example.Customer_Management_System.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICustomerRepo extends JpaRepository<Customer,Integer> {

}
