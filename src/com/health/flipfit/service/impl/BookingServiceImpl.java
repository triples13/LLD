package com.health.flipfit.service.impl;

import com.health.flipfit.model.Booking;
import com.health.flipfit.model.SlotType;
import com.health.flipfit.model.WorkOutType;
import com.health.flipfit.service.BookingService;
import com.health.flipfit.service.BookingStrategy;

import java.util.Date;


public class BookingServiceImpl implements BookingService {

    BookingStrategy bookingStrategy;

    @Override
    public Booking bookCenter(Date date, int startTime, int endTime, String slotType, String workOutType) {
        bookingStrategy.findSlot(date,startTime,endTime, SlotType.valueOf(slotType), WorkOutType.valueOf(workOutType));
        return  null;
    }
}
