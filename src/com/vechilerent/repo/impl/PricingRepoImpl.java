package com.vechilerent.repo.impl;

import com.vechilerent.model.Pricing;
import com.vechilerent.repo.PricingRepo;

import java.util.ArrayList;
import java.util.List;

public class PricingRepoImpl implements PricingRepo {

    private List<Pricing> pricingList;

    public PricingRepoImpl() {
        this.pricingList = new ArrayList<>();
    }

    @Override
    public void addPricing(Pricing pricing) {
        this.pricingList.add(pricing);
    }

    @Override
    public List<Pricing> pricingList() {
        return this.pricingList;
    }
}
