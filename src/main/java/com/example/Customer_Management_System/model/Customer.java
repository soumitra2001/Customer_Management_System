package com.example.Customer_Management_System.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String first_name;

    private String last_name;

    private String street;

    private String address;

    private String city;

    private String state;

    @Email(message = "Enter a valid email ID")
    private String email;

    @Length(min = 10,max = 14,message = "Please enter a valid phone no")
    private String phone;
}
