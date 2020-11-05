package com.lambdaschool.javaorders.controllers;


import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.services.CustomersService;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    CustomersService customersService;

    //http://localhost:2019/customers/orders
    // Returns all customers with their orders
    @GetMapping(value = "/orders", produces = {"application/json"})
    public ResponseEntity<?> ListAllCustomers()
    {
        List<Customers> rtnList = customersService.findAllCustomers();
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }


    //http://localhost:2019/customers/customer/7
    //http://localhost:2019/customers/customer/77
    //Returns the customer and their orders with the given customer id
    @GetMapping(value = "/customer/{custid}", produces = {"application/json"})
    public ResponseEntity<?> findByCustomerId(@PathVariable long custid)
    {
        Customers rtnCust = customersService.findByCustomerId(custid);
        return new ResponseEntity<>(rtnCust, HttpStatus.OK);
    }


    //http://localhost:2019/customers/namelike/mes
    //http://localhost:2019/customers/namelike/cin
    //Returns all customers and their orders with a customer name containing the given substring
    @GetMapping(value = "/namelike/{subname}", produces = {"application/json"})
    public ResponseEntity<?> findCustomersLikeName(@PathVariable String subname)
    {
        List<Customers> rtnList = customersService.findCustomersByLikeName(subname);
        return new ResponseEntity<>(rtnList, HttpStatus.OK);
    }


//http://localhost:2019/agents/agent/9
//Returns the agent and their customers with the given agent id


//http://localhost:2019/orders/order/7
//Returns the order and its customer with the given order number
}
