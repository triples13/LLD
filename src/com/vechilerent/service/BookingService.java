package com.vechilerent.service;

import com.vechilerent.model.VechileType;

import java.time.LocalDateTime;

public interface BookingService {

    public void bookVechile(VechileType vechileType, LocalDateTime startTime, LocalDateTime endTime);
    public BookingPreview getBookingPreview(LocalDateTime startTime, LocalDateTime endTime);
}
