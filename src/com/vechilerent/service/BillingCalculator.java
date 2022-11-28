package com.vechilerent.service;

import com.vechilerent.model.Vechile;

import java.time.LocalDateTime;

public interface BillingCalculator {
    public Double calculateFinalBill(Vechile vechile, LocalDateTime startTime, LocalDateTime endTime);
}
