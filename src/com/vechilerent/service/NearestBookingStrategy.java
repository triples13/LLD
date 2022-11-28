package com.vechilerent.service;

import com.vechilerent.model.Vechile;
import com.vechilerent.model.VechileType;

import java.time.LocalDateTime;
import java.util.Optional;

public class NearestBookingStrategy implements BookingStartegy {

    @Override
    public Optional<Vechile> findBranch(VechileType vechileType, LocalDateTime startTime, LocalDateTime endTime) {
        return Optional.empty();
    }
}
