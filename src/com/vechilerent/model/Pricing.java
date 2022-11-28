package com.vechilerent.model;

import java.util.Map;

public class Pricing {

    private String branchName;
    private Map<VechileType,Integer> priceByVechileType;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Map<VechileType, Integer> getPriceByVechileType() {
        return priceByVechileType;
    }

    public void setPriceByVechileType(Map<VechileType, Integer> priceByVechileType) {
        this.priceByVechileType = priceByVechileType;
    }
}
