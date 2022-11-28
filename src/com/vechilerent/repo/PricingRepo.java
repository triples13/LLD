package com.vechilerent.repo;

import com.vechilerent.model.Pricing;

import java.util.List;

public interface PricingRepo {

    public void addPricing(Pricing pricing);
    public List<Pricing> pricingList();
}
