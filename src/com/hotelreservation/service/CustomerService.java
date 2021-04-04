package com.hotelreservation.service;

import com.hotelreservation.model.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerService {
    private static Collection<Customer> customers = new ArrayList<>();
    public void addCustomer(String firstName, String lastName, String email) {
        Customer customer =  new Customer(firstName,lastName, email);
        customers.add(customer);
    }
    public Customer getCustomer(String email) {
        for(Customer customer : customers) {
            if(customer.getEmail().equalsIgnoreCase(email)) {
                return customer;
            }
        }
        return null;
    }
    public Collection<Customer> getAllCustomers() {
        return customers;
    }
}
