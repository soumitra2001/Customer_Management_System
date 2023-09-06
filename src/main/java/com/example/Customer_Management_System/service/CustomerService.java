package com.example.Customer_Management_System.service;

import com.example.Customer_Management_System.model.Customer;
import com.example.Customer_Management_System.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    ICustomerRepo customerRepo;

    public List<Customer> getAllCustomer(){
        return customerRepo.findAll();
    }

    public void addCustomer(Customer customer) {
        customerRepo.save(customer);
    }

    public void editCustomer(int id,Customer customer) {
        Customer oldCustomer=customerRepo.findById(id).get();
        oldCustomer.setFirst_name(customer.getFirst_name());
        oldCustomer.setLast_name(customer.getLast_name());
        oldCustomer.setStreet(customer.getStreet());
        oldCustomer.setAddress(customer.getAddress());
        oldCustomer.setState(customer.getState());
        oldCustomer.setCity(customer.getCity());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhone(customer.getPhone());
        customerRepo.save(oldCustomer);
    }

    public Customer getCustomerById(int id) {
        return customerRepo.findById(id).get();
    }

    public void deleteCustomer(int id) {
        customerRepo.deleteById(id);
    }
}
