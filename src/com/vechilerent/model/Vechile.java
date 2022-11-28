package com.vechilerent.model;

public class Vechile {

    private String branchName;
    private VechileType vechileType;
    private String vechileId;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public VechileType getVechileType() {
        return vechileType;
    }

    public void setVechileType(VechileType vechileType) {
        this.vechileType = vechileType;
    }

    public String getVechileId() {
        return vechileId;
    }

    public void setVechileId(String vechileId) {
        this.vechileId = vechileId;
    }
}
