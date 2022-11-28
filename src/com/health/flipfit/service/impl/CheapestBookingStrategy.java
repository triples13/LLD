package com.health.flipfit.service.impl;

import com.health.flipfit.model.Center;
import com.health.flipfit.model.Slot;
import com.health.flipfit.model.SlotType;
import com.health.flipfit.model.WorkOutType;
import com.health.flipfit.service.AdminService;
import com.health.flipfit.service.BookingStrategy;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CheapestBookingStrategy  implements BookingStrategy {

    AdminService adminService;
    @Override
    public Slot findSlot(Date date, int startTime, int endTime, SlotType slotType, WorkOutType workOutType) {
       var centerList =  adminService.getCenter();
       filterSlotBySlotTypeAndWorkOutType(centerList,slotType,workOutType);
       return  null;
    }

    private List<Slot> filterSlotBySlotTypeAndWorkOutType(List<Center> centers,SlotType slotType, WorkOutType workOutType){

         var slotList = centers.stream().map(Center::getSlots).collect(Collectors.toList()).stream().flatMap(List::stream).collect(Collectors.toList());
         return slotList.stream().filter(slot -> slot.getSlotType().equals(slotType) && slot.getWorkOutType().equals(workOutType)).collect(Collectors.toList());
    }
}
