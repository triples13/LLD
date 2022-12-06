package com.vendingmachine.model;


import com.vendingmachine.repo.ProductRepo;

public class VendingMachine {

    ProductRepo productRepo;
    double collectedCash;
    double totalCash;

    public ProductRepo getProductRepo() {
        return productRepo;
    }

    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    State state;

    public void collectMoney(double cash){
        this.state.collectCash(cash);
    }

    public double dispenseChange(String productId){
       return this.state.dispenseChange(productId);
    }

    public Product dispenseProduct(String productId){
       return this.state.dispenseProduct(productId);
    }

    public Product dispenseItem(String productId){

        Product product =  productRepo.findProductByProductId(productId);
        productRepo.updateProductInventory(productId);
        return product;
    }
    public double collectCash(double amount){
         this.collectedCash = amount;
         return this.totalCash+amount;
    }

    public double calculateChange(String productId){
        return this.collectedCash- productRepo.findPriceByProductId(productId);
    }

    public void cancelProcess(){
        System.out.println("transaction is cancelled");
    }

    public void cancelTransaction(){
        this.state.cancelTransaction();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
