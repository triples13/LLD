package com.health.flipfit.service;

import com.health.flipfit.model.Center;
import com.health.flipfit.model.Slot;
import com.health.flipfit.model.SlotType;
import com.health.flipfit.model.WorkOutType;

import java.util.Date;

public interface BookingStrategy {

    public Slot findSlot(Date date, int startTime, int endTime, SlotType slotType, WorkOutType workOutType);
}
