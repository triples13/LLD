package com.vechilerent.service.impl;

import com.vechilerent.model.*;
import com.vechilerent.repo.BranchRepo;
import com.vechilerent.repo.PricingRepo;
import com.vechilerent.service.AdminPanel;

import java.util.*;

public class AdminPanelImpl implements AdminPanel {

    BranchRepo branchRepo;
    PricingRepo pricingRepo;
    public AdminPanelImpl(BranchRepo branchRepo, PricingRepo pricingRepo){
      this.branchRepo = branchRepo;
      this.pricingRepo = pricingRepo;
    }

    @Override
    public void addBranch(String branchName,List<String> userRequest) {

        Branch branch = new Branch();
        branch.setBranchName(branchName);
        Map<VechileType,Integer> vechileTypeTotalVechileMapping = new HashMap<>();
        Map<VechileType,Integer> vechileTypePriceMapping = new HashMap<>();

        List<Vechile> vechileList = new ArrayList<>();
        for(String input: userRequest){
           String [] inputs =  input.split(" ");
           int totalCars = Integer.valueOf(inputs[0]);
            VechileType vechileType = VechileType.valueOf(inputs[1]);
           for(int i=0;i<totalCars;i++){
               Vechile vechile = new Vechile();
               vechile.setBranchName(branchName);
               vechile.setVechileId(String.valueOf(Math.random()));
               vechile.setVechileType(vechileType);
               vechileList.add(vechile);
           }

           int price = Integer.valueOf(inputs[2]);
           vechileTypePriceMapping.put(vechileType, price);
           vechileTypeTotalVechileMapping.put(vechileType, totalCars);
        }


        Pricing pricing = new Pricing();
        pricing.setBranchName(branchName);
        pricing.setPriceByVechileType(vechileTypePriceMapping);

        branch.setVechileList(vechileList);
        branch.setTotalVechilesByVechileType(vechileTypeTotalVechileMapping);
        branch.setPricing(pricing);

        branchRepo.addBranch(branch);
        pricingRepo.addPricing(pricing);

    }
}
