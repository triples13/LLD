package com.vechilerent.repo.impl;

import com.vechilerent.model.Branch;
import com.vechilerent.repo.BranchRepo;

import java.util.ArrayList;
import java.util.List;

public class BranchRepoImpl implements BranchRepo {

    private List<Branch> branchList;

    public BranchRepoImpl() {
        this.branchList = new ArrayList<>();
    }

    @Override
    public void addBranch(Branch branch) {
         branchList.add(branch);
    }

    @Override
    public List<Branch> getAllBranches() {
        return this.branchList;
    }
}
