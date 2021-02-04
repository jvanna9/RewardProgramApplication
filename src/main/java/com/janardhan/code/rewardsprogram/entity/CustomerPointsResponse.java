package com.janardhan.code.rewardsprogram.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerPointsResponse {
    private Customer customer;
    private Double rewardPoints;
    private Double totalTransactions;
    private int numberOfTransactions;
}
