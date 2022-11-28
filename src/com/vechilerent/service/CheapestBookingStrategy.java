package com.vechilerent.service;

import com.vechilerent.model.Booking;
import com.vechilerent.model.Branch;
import com.vechilerent.model.Vechile;
import com.vechilerent.model.VechileType;
import com.vechilerent.repo.BookingRepo;
import com.vechilerent.repo.BranchRepo;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class CheapestBookingStrategy implements BookingStartegy {

    FreeSlotIndicatorService freeSlotIndicatorService;
    BookingRepo bookingRepo;
    BranchRepo branchRepo;

    public CheapestBookingStrategy(FreeSlotIndicatorService freeSlotIndicatorService, BookingRepo bookingRepo, BranchRepo branchRepo) {
        this.freeSlotIndicatorService = freeSlotIndicatorService;
        this.bookingRepo = bookingRepo;
        this.branchRepo = branchRepo;
    }

    public void sortBranchByVehcileTypeHavingLowestPrice(List<Branch> branchList, VechileType vechileType){
        Collections.sort(branchList, (Comparator.comparingInt((Branch b) -> b.getPricing().getPriceByVechileType().get(vechileType))));
    }

    @Override
    public Optional<Vechile> findBranch(VechileType vechileType, LocalDateTime startTime, LocalDateTime endTime) {
        var branchList =  branchRepo.getAllBranches().stream().filter((branch -> branch.getTotalVechilesByVechileType().get(vechileType)!=null)).collect(Collectors.toList());
        sortBranchByVehcileTypeHavingLowestPrice(branchList,vechileType);
        for(Branch branch: branchList){
             var bookingsByBranch =  bookingRepo.findAllBookingByVechileTypeGivenSlot(branch.getBranchName(),vechileType,startTime,endTime);
             var bookedVechileList = bookingsByBranch.stream().map(e->e.getVechile()).collect(Collectors.toList());
             var availableVechiles = branch.getVechileList().stream().filter(e->e.getVechileType().equals(vechileType)).collect(Collectors.toList()) ;

             if (bookingsByBranch.isEmpty())
                 return Optional.of(availableVechiles.get(0));

             else if (availableVechiles.size()>availableVechiles.size())
                 return getAvailableVechile(availableVechiles,bookedVechileList);
        }

     throw  new IllegalArgumentException("no cars avaialble");
    }

    public Optional<Vechile> getAvailableVechile(List<Vechile> availableVechiles, List<Vechile> boookedVechiles){
      return availableVechiles.stream().filter(vechile -> !boookedVechiles.contains(vechile.getVechileId())).findFirst();
    }
}
