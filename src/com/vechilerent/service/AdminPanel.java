package com.vechilerent.service;

import com.vechilerent.model.Branch;
import com.vechilerent.model.VechileType;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public interface AdminPanel {

    public void addBranch(String branchName, List<String> userRequest);
}
