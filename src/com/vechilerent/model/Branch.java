package com.vechilerent.model;


import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Branch {

    private String branchName;
    private String address;

    private Map<VechileType,Integer> totalVechilesByVechileType;

    private List<Vechile> vechileList;
    private Pricing pricing;

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
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

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(branchName, branch.branchName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branchName);
    }
}
