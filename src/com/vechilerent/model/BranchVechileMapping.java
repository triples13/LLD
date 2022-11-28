package com.vechilerent.model;

import java.util.List;
import java.util.Map;

public class BranchVechileMapping {

    private String BranchName;
    private Map<VechileType,Integer> totalVechilesByVechileType;
    private List<Vechile> vechileList;
    private Map<VechileType,Integer> priceOfVechileByVechileType;

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public Map<VechileType, Integer> getTotalVechilesByVechileType() {
        return totalVechilesByVechileType;
    }

    public void setTotalVechilesByVechileType(Map<VechileType, Integer> totalVechilesByVechileType) {
        this.totalVechilesByVechileType = totalVechilesByVechileType;
    }

    public List<Vechile> getVechileList() {
        return vechileList;
    }

    public void setVechileList(List<Vechile> vechileList) {
        this.vechileList = vechileList;
    }

    public Map<VechileType, Integer> getPriceOfVechileByVechileType() {
        return priceOfVechileByVechileType;
    }

    public void setPriceOfVechileByVechileType(Map<VechileType, Integer> priceOfVechileByVechileType) {
        this.priceOfVechileByVechileType = priceOfVechileByVechileType;
    }
}
