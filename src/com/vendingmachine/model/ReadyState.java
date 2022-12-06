package com.vendingmachine.model;

public class ReadyState extends State{

    public ReadyState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public Product dispenseProduct(String productId) {
        throw new RuntimeException("can't disburse product while collecting change");
    }

    @Override
    public double dispenseChange(String productId) {
        throw new RuntimeException("can't disburse change while collecting cash");
    }

    @Override
    public void cancelTransaction() {
        this.vendingMachine.setState(new CancelState(this.vendingMachine));
        this.vendingMachine.cancelTransaction();
    }

    @Override
    public void collectCash(double cash) {
        this.vendingMachine.collectCash(cash);
        this.vendingMachine.setState(new DispenseChangeState(vendingMachine));
    }
}
