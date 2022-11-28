package com.vechilerent.model;

import java.time.LocalDateTime;

public class Booking implements Comparable<Booking> {

    private String branchName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Vechile vechile;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Vechile getVechile() {
        return vechile;
    }

    public void setVechile(Vechile vechile) {
        this.vechile = vechile;
    }

    @Override
    public int compareTo(Booking o) {
        return this.startTime.compareTo(o.startTime);
    }
}
