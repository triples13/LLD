package com.health.flipfit.model;

import java.util.List;


public class Booking {

    private User user;
    private List<Slot> slot;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Slot> getSlot() {
        return slot;
    }

    public void setSlot(List<Slot> slot) {
        this.slot = slot;
    }
}
