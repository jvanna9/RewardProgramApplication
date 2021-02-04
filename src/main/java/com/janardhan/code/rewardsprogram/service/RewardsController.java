package com.janardhan.code.rewardsprogram.service;

import com.janardhan.code.rewardsprogram.entity.Customer;
import com.janardhan.code.rewardsprogram.entity.CustomerPointsResponse;
import com.janardhan.code.rewardsprogram.entity.CustomerTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Set;

@RestController
public class RewardsController {

    @Autowired
    private RewardPointService rewardPointService;

    @Autowired
    private RewardService rewardService;

    @GetMapping("/customers")
    public List<Customer> findCustomerAll() {
        return rewardService.getCustomerAll();
    }

    @GetMapping("/customers/{id}/{month}")
    public ResponseEntity<CustomerPointsResponse> getCustomer(@PathVariable Integer id, @PathVariable String month) {
        Customer customer = rewardService.getCustomerById(id);
        if (customer == null) return new ResponseEntity<CustomerPointsResponse>(HttpStatus.NOT_FOUND);
        Set<CustomerTransaction> transactions = customer.getTransactions();
        Double total = 0.0;
        Double rewardPoints = 0.0;
        int counter = 0;
        for(CustomerTransaction ct:transactions)
        {
            String mon = new SimpleDateFormat("MMM").format(ct.getSaveDate());

            if(mon.equals(month)) {
                System.out.println(mon);
                total += ct.getTotal();
                counter++;
            }

        }

        rewardPoints =  rewardPointService.getRewardPointsFromTotal(total);

        return new ResponseEntity<CustomerPointsResponse>(new CustomerPointsResponse(customer,rewardPoints,total,counter), HttpStatus.OK);

    }
}
