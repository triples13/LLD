package com.vechilerent.repo.impl;

import com.vechilerent.model.Booking;
import com.vechilerent.model.VechileType;
import com.vechilerent.repo.BookingRepo;
import com.vechilerent.repo.BranchRepo;
import com.vechilerent.service.AdminPanel;
import com.vechilerent.service.impl.AdminPanelImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingRepoImpl implements BookingRepo {

    public List<Booking> bookingList;


    public BookingRepoImpl() {
        this.bookingList = new ArrayList<>();
    }

    @Override
    public List<Booking> findAllBookingByVechileTypeGivenSlot(String branchName,VechileType vechileType, LocalDateTime startTime, LocalDateTime endTime) {
       return bookingList.stream().filter((Booking b)->  b.getBranchName().equals(branchName) && b.getVechile().getVechileType().equals(vechileType) && (startTime.isEqual(b.getStartTime()) && endTime.isEqual(b.getEndTime()))).collect(Collectors.toList());
    }

    @Override
    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    @Override
    public List<Booking> findAllBookingByBranchName(String branchName) {
        return bookingList.stream().filter(b->b.getBranchName().equals(branchName)).collect(Collectors.toList());
    }

    public List<Booking> getAllBookings(){
        return this.bookingList;
    }
}
