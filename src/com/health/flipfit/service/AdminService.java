package com.health.flipfit.service;

import com.health.flipfit.model.Center;

import java.util.Date;
import java.util.List;

public interface AdminService {

    public void addCenter(String name);
    public void addSlot(int centerId, Date date, int starTime, int endTime, int capacity, String workOutType, String slotType);
    public List<Center> getCenter();

}
