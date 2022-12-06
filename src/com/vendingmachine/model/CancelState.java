package com.vendingmachine.model;

public class CancelState extends State{

    CancelState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public Product dispenseProduct(String productId) {
        throw new IllegalArgumentException("can't disburse product");
    }

    @Override
    public double dispenseChange(String productId) {
        throw new IllegalArgumentException("can;t disburse change");
    }

    @Override
    public void cancelTransaction() {
        this.vendingMachine.cancelProcess();
        this.vendingMachine.setState(new ReadyState(this.vendingMachine));
    }

    @Override
    public void collectCash(double cash) {
        throw new IllegalArgumentException("can't collect cash");
    }
}
