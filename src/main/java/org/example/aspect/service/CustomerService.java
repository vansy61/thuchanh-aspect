package org.example.aspect.service;

import org.example.aspect.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Override
    public List<Customer> findAll() throws Exception {
        throw new Exception("Lỗi trong find all");
    }

    @Override
    public Customer findOne(Long id) throws Exception {
        Customer customer = new Customer();
        if (customer.getName() == null) {
            throw new Exception("Không tìm thấy khách hàng");
        }
        return customer;
    }
}
