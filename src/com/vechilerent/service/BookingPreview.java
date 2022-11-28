package com.vechilerent.service;

import com.vechilerent.model.Branch;

import java.util.List;
import java.util.Map;

public class BookingPreview {

    Map<String, List<String>> bookingPreview;

    public Map<String, List<String>> getBookingPreview() {
        return bookingPreview;
    }

    public void setBookingPreview(Map<String, List<String>> bookingPreview) {
        this.bookingPreview = bookingPreview;
    }

    @Override
    public String toString() {
        return "BookingPreview{" +
                "bookingPreview=" + bookingPreview +
                '}';
    }
}
