package com.vechilerent.service.impl;

import com.vechilerent.model.Booking;
import com.vechilerent.model.Branch;
import com.vechilerent.model.Vechile;
import com.vechilerent.model.VechileType;
import com.vechilerent.repo.BookingRepo;
import com.vechilerent.repo.BranchRepo;
import com.vechilerent.repo.PricingRepo;
import com.vechilerent.service.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    AdminPanel adminPanel;
    BookingStartegy bookingStartegy;

    FreeSlotIndicatorService freeSlotIndicatorService;

    BookingRepo bookingRepo;

    BranchRepo branchRepo;

    PricingRepo pricingRepo;

    public BookingServiceImpl(BookingRepo bookingRepo,BranchRepo branchRepo,PricingRepo pricingRepo,AdminPanel adminPanel, BookingStartegy bookingStartegy, FreeSlotIndicatorService freeSlotIndicatorService) {
        this.bookingRepo = bookingRepo;
        this.branchRepo = branchRepo;
        this.pricingRepo = pricingRepo;
        this.adminPanel = adminPanel;
        this.bookingStartegy = bookingStartegy;
        this.freeSlotIndicatorService = freeSlotIndicatorService;
    }

    @Override
    public void bookVechile(VechileType vechileType, LocalDateTime startTime, LocalDateTime endTime) {
              Optional<Vechile> vechile =   getVechileByStrategy(vechileType, startTime, endTime);

              if(vechile.isEmpty()){
                  throw new IllegalArgumentException("No Cars are available for type");
              }else {
                  var availableVechile = vechile.get();
                  var branchName = availableVechile.getBranchName();
                  var branch = branchRepo.getAllBranches().stream().filter(branch1 -> branch1.getBranchName().equals(branchName)).findFirst().get();
                  var bookingList = bookingRepo.getAllBookings();
                  var newBooking = createBooking(branch,availableVechile,startTime,endTime);
                  bookingList.add(newBooking);
              }
    }

    @Override
    public BookingPreview getBookingPreview(LocalDateTime startTime, LocalDateTime endTime) {
        var branchList = branchRepo.getAllBranches();
        BookingPreview bookingPreview = new BookingPreview();
        Map<String,List<String>> bookStatus = new HashMap<>();
        for(Branch branch: branchList){

           var bookingList =  bookingRepo.findAllBookingByBranchName(branch.getBranchName());
           var branchVechileMapping = branch.getTotalVechilesByVechileType();


            List<String> bookingStatus = new ArrayList<>();
           for(Map.Entry<VechileType,Integer> entry: branchVechileMapping.entrySet()){
              VechileType vechileType = entry.getKey();
               var totalAvailableVechiles = branch.getTotalVechilesByVechileType().get(vechileType);
               var bookedVechiles = bookingRepo.findAllBookingByVechileTypeGivenSlot(branch.getBranchName(),vechileType,startTime,endTime);
               var priceOfVechile = pricingRepo.pricingList().stream().filter(e->e.getBranchName().equals(branch.getBranchName())).findFirst().get().getPriceByVechileType().get(vechileType);

               if(totalAvailableVechiles == bookedVechiles.size())
                   bookingStatus.add("All Vechiles of type :"+vechileType+" are booked");
               if(totalAvailableVechiles>bookedVechiles.size())
                   bookingStatus.add(vechileType+" is available at price of: "+priceOfVechile);

           }

            bookStatus.put(branch.getBranchName(), bookingStatus);
        }
        bookingPreview.setBookingPreview(bookStatus);

        return bookingPreview;
    }


    private Optional<Vechile> getVechileByStrategy(VechileType vechileType, LocalDateTime startTime, LocalDateTime endTime){
       return bookingStartegy.findBranch(vechileType, startTime, endTime);
    }

    private Booking createBooking(Branch branch,Vechile vechile, LocalDateTime startTime,LocalDateTime endTime){
        Booking booking = new Booking();
        booking.setBranchName(branch.getBranchName());
        booking.setStartTime(startTime);
        booking.setEndTime(endTime);
        booking.setVechile(vechile);

        return booking;
    }
}
