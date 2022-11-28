package com.health.flipfit.model;

import java.util.Date;

public class Slot {

    private int centerId;
    private Date date;
    private int startTime;
    private int endTime;
    private SlotType slotType;
    private int capacity;
    private WorkOutType workOutType;

    public int getCenterId() {
        return centerId;
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public SlotType getSlotType() {
        return slotType;
    }

    public void setSlotType(SlotType slotType) {
        this.slotType = slotType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public WorkOutType getWorkOutType() {
        return workOutType;
    }

    public void setWorkOutType(WorkOutType workOutType) {
        this.workOutType = workOutType;
    }
}
