package com.vechilerent.repo;

import com.vechilerent.model.Branch;

import java.util.List;

public interface BranchRepo {

    public void addBranch(Branch branch);
    public List<Branch> getAllBranches();
}
