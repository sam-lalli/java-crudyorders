package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Customers;

import java.util.List;

public interface CustomersService
{

    List<Customers> findAllCustomers();

    Customers findByCustomerId(long id);

    List<Customers> findCustomersByLikeName(String name);

    Customers save(Customers customers);

}
