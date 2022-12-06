package com.vendingmachine.service;

import com.vendingmachine.model.Product;
import com.vendingmachine.model.ReadyState;
import com.vendingmachine.model.VendingMachine;
import com.vendingmachine.repo.ProductRepo;
import com.vendingmachine.repo.impl.ProductRepoImpl;

public class VendingService {

    ProductRepo productRepo;

    VendingMachine vendingMachine;

    public VendingService(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
        this.productRepo = new ProductRepoImpl();
        this.vendingMachine.setProductRepo(productRepo);
    }

    public void addProduct(String productId,String productName,double price){
        Product product = new Product();
        product.setName(productName);
        product.setId(productId);
        product.setPrice(price);
        productRepo.addProduct(product);
    }

    public void collectCash(double price){
        ReadyState readyState = new ReadyState(this.vendingMachine);
        this.vendingMachine.setState(readyState);
        this.vendingMachine.collectMoney(price);
    }

    public Product disburseItem(String productId){
      return  this.vendingMachine.dispenseProduct(productId);
    }

    public Double collectChange(String productId){
        return this.vendingMachine.dispenseChange(productId);
    }

}
