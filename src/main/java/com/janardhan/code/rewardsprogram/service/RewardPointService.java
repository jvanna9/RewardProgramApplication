package com.janardhan.code.rewardsprogram.service;

import com.janardhan.code.rewardsprogram.entity.Customer;
import com.janardhan.code.rewardsprogram.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RewardPointService {
    @Autowired
    private CustomerRepository customerRepository;
    private Double points = 0.0;
    public Double getRewardPointsFromTotal(Double total)
    {
        if(total > 50 && total <= 100)
        {
            points = (total - 50);
        }
        else
        {
            points = (total - 100) * 2 + 50;
        }
        return points;
    }




    public List<Customer> getCustomerAll() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).orElse(null);
    }

}
