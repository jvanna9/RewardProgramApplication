package com.janardhan.code.rewardsprogram.service;

import org.springframework.stereotype.Component;


@Component
public class RewardPointService {
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

}
