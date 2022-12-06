package com.vendingmachine.model;

public abstract class State {

    VendingMachine vendingMachine;
    public abstract Product dispenseProduct(String productId);
    public abstract double dispenseChange(String productId);
    public abstract void cancelTransaction();
    public abstract void collectCash(double cash);

}
