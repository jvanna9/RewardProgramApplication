package com.janardhan.code.rewardsprogram.service;

import com.janardhan.code.rewardsprogram.entity.Customer;
import com.janardhan.code.rewardsprogram.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardService {
    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getCustomerAll() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

}
