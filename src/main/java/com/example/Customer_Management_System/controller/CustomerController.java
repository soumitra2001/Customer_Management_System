package com.example.Customer_Management_System.controller;

import com.example.Customer_Management_System.dto.Logindto;
import com.example.Customer_Management_System.model.Customer;
import com.example.Customer_Management_System.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/login")
    public String loginPage(Model model){
        model.addAttribute("loginData",new Logindto());
        return "login_page";
    }

    @PostMapping("/login")
    public String authenticate(@ModelAttribute Logindto logindto){
        if(logindto.getEmail().equals("supriya@admin.com") && logindto.getPassword().equals("root"))return "redirect:/customers";
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("customer",new Customer());
        return "register_page";
    }

    @PostMapping("/register")
    public String saveCustomer(@ModelAttribute("customer") Customer customer){
        customerService.addCustomer(customer);
        return "redirect:/customers";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable int id, Model model){
        model.addAttribute("customer",customerService.getCustomerById(id));
        return "update_page";
    }

    @PostMapping("/update/{id}")
    public String editCustomer(@PathVariable int id, @ModelAttribute("customer") Customer customer){
        customerService.editCustomer(id,customer);
        return "redirect:/customers";
    }

    @GetMapping("/customers")
    public String getAllCustomer(Model model){
        model.addAttribute("customers",customerService.getAllCustomer());
        return "customer_table";
    }

    @GetMapping("/delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        customerService.deleteCustomer(id);
        return "redirect:/customers";
    }


}
