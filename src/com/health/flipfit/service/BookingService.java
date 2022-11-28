package com.health.flipfit.service;

import com.health.flipfit.model.Booking;

import java.util.Date;

public interface BookingService {

    public Booking bookCenter(Date date, int startTime, int endTime, String slotType, String workOutType);
}
