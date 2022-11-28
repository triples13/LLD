package com.vechilerent.Test;

import com.vechilerent.model.VechileType;
import com.vechilerent.repo.BookingRepo;
import com.vechilerent.repo.BranchRepo;
import com.vechilerent.repo.PricingRepo;
import com.vechilerent.repo.impl.BookingRepoImpl;
import com.vechilerent.repo.impl.BranchRepoImpl;
import com.vechilerent.repo.impl.PricingRepoImpl;
import com.vechilerent.service.AdminPanel;
import com.vechilerent.service.BookingService;
import com.vechilerent.service.CheapestBookingStrategy;
import com.vechilerent.service.FreeSlotIndicatorService;
import com.vechilerent.service.impl.AdminPanelImpl;
import com.vechilerent.service.impl.BookingServiceImpl;
import com.vechilerent.sigleton.SingletonFactory;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class Driver {

    public static void main(String [] args) throws InstantiationException, IllegalAccessException {

        BookingRepo bookingRepo = SingletonFactory.getInstance(BookingRepoImpl.class);
        PricingRepo pricingRepo = SingletonFactory.getInstance(PricingRepoImpl.class);
        BranchRepo branchRepo = SingletonFactory.getInstance(BranchRepoImpl.class);

        AdminPanel adminPanel = new AdminPanelImpl(branchRepo,pricingRepo);

        List<String> requets = Arrays.asList("1 Suv 12","1 Sedan 10","3 Bike 20");
        adminPanel.addBranch("koramangala",requets);

        requets = Arrays.asList("1 Sedan 11","3 Bike 30","4 HatchBack 8");
        adminPanel.addBranch("jayanagar",requets);
        requets = Arrays.asList("1 Suv 11","10 Bike 3","1 Sedan 10");
        adminPanel.addBranch("malleshwaram",requets);

        FreeSlotIndicatorService freeSlotIndicatorService = new FreeSlotIndicatorService();
        BookingService bookingService = new BookingServiceImpl(bookingRepo,branchRepo,pricingRepo,adminPanel, new CheapestBookingStrategy(freeSlotIndicatorService,bookingRepo,branchRepo), freeSlotIndicatorService);

        bookingService.bookVechile(VechileType.Suv, LocalDateTime.of(2022, Month.DECEMBER,23,10,0),LocalDateTime.of(2022, Month.DECEMBER,23,11,0));
        bookingService.bookVechile(VechileType.Suv, LocalDateTime.of(2022, Month.DECEMBER,23,10,0),LocalDateTime.of(2022, Month.DECEMBER,23,11,0));
        bookingService.bookVechile(VechileType.Sedan, LocalDateTime.of(2022, Month.DECEMBER,23,12,0),LocalDateTime.of(2022, Month.DECEMBER,23,14,0));
        bookingService.bookVechile(VechileType.Sedan, LocalDateTime.of(2022, Month.DECEMBER,23,12,0),LocalDateTime.of(2022, Month.DECEMBER,23,14,0));
        bookingService.bookVechile(VechileType.Sedan, LocalDateTime.of(2022, Month.DECEMBER,23,12,0),LocalDateTime.of(2022, Month.DECEMBER,23,14,0));
    //    bookingService.bookVechile(VechileType.Sedan, LocalDateTime.of(2022, Month.DECEMBER,23,12,0),LocalDateTime.of(2022, Month.DECEMBER,23,14,0));
        System.out.println(bookingService.getBookingPreview(LocalDateTime.of(2022, Month.DECEMBER,23,10,0),LocalDateTime.of(2022, Month.DECEMBER,23,11,0)));
        System.out.println(bookingService.getBookingPreview(LocalDateTime.of(2022, Month.DECEMBER,23,12,0),LocalDateTime.of(2022, Month.DECEMBER,23,14,0)));
    }
}
