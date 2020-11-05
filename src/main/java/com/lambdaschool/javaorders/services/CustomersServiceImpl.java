package com.lambdaschool.javaorders.services;


import com.lambdaschool.javaorders.models.Customers;
import com.lambdaschool.javaorders.repositories.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Service(value = "customerservice")
public class CustomersServiceImpl implements CustomersService {

    @Autowired
    CustomersRepository customerrepo;

    @Override
    public List<Customers> findAllCustomers() {
        List<Customers> list = new ArrayList<>();
        customerrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Customers findByCustomerId(long id)
    {
        Customers rtnCust = customerrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer" + id + " Not Found"));
        return rtnCust;
    }

    @Override
    public List<Customers> findCustomersByLikeName(String name)
    {
        List<Customers> rtnList = customerrepo.findByNameContainingIgnoreCase(name);
        return rtnList;
    }
    @Transactional
    @Override
    public Customers save(Customers customers) {
        return customerrepo.save(customers);
    }
}
