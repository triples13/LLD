package com.vechilerent.repo;

import com.vechilerent.model.Booking;
import com.vechilerent.model.VechileType;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepo {

    public List<Booking> findAllBookingByVechileTypeGivenSlot(String branchName,VechileType vechileType, LocalDateTime startTime, LocalDateTime endTime);
    public void addBooking(Booking booking);
    public List<Booking> findAllBookingByBranchName(String branchName);

    public List<Booking> getAllBookings();
}
