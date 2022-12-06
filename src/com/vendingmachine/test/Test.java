package com.vendingmachine.test;

import com.vendingmachine.model.Product;
import com.vendingmachine.model.ReadyState;
import com.vendingmachine.model.VendingMachine;
import com.vendingmachine.service.VendingService;

public class Test {

    public static void main(String [] args){

        VendingMachine vendingMachine = new VendingMachine();
        VendingService vendingService = new VendingService(vendingMachine);
        vendingService.addProduct("12","coke",23.0);
        vendingService.addProduct("13","diet coke",24.0);
        vendingService.addProduct("14","lays",26.0);
        vendingService.addProduct("15","egg",28.0);

        vendingService.collectCash(30.0);
        double changeCollected = vendingService.collectChange("13");
        System.out.println("change collected:"+changeCollected);
        Product product = vendingService.disburseItem("13");
        System.out.println("product disbursed:"+product.getId());


        vendingService.collectCash(50.0);
        double collectChange = vendingService.collectChange("15");
        System.out.println("change collected:"+collectChange);
        Product product1 = vendingService.disburseItem("15");
        System.out.println("product disbursed:"+product1.getId());


    }
}
