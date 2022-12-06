package com.vendingmachine.model;

public class DispenseItemState extends State{

    DispenseItemState (VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public Product dispenseProduct(String productId) {
        Product product = this.vendingMachine.dispenseItem(productId);
        this.vendingMachine.setState(new DispenseChangeState(this.vendingMachine));
        return product;
    }

    @Override
    public double dispenseChange(String productId) {
        throw  new IllegalArgumentException("can't disburse change while disbursing item");
    }

    @Override
    public void cancelTransaction() {
        throw  new IllegalArgumentException("can't disburse cancel transaction");
    }

    @Override
    public void collectCash(double cash) {
        throw  new IllegalArgumentException("can't collect cash");
    }
}
