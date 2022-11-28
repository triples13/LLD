package com.vechilerent.service;

import com.vechilerent.model.Booking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FreeSlotIndicatorService {

    public List<String> checkBookedVechilesInTimeSlot(List<Booking> bookingList, LocalDateTime startTime, LocalDateTime endTime){

        List<String> bookedVechile = new ArrayList<>();
        for(Booking booking: bookingList){
            if(!(startTime.isAfter(booking.getEndTime()) || endTime.isBefore(booking.getStartTime())))
                bookedVechile.add(booking.getVechile().getVechileId());

        }

        return bookedVechile;
    }
}
