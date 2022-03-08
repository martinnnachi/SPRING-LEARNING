package com.martinnnachi.springdemo.service;

import com.martinnnachi.springdemo.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomers(int theSortField);

    void saveCustomer(Customer theCustomer);

    Customer getCustomer(int theId);

    void deleteCustomer(int theId);

    List<Customer> searchCustomers(String theSearchName);
}
