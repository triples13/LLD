package com.vendingmachine.model;

public class DispenseChangeState extends State{

    DispenseChangeState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    @Override
    public Product dispenseProduct(String productId) {
        throw new IllegalArgumentException("can't dispense product as disbursing change");
    }


    @Override
    public double dispenseChange(String productId) {
        double changeCollected = this.vendingMachine.calculateChange(productId);
        this.vendingMachine.setState(new DispenseItemState(vendingMachine));
        return changeCollected;
    }

    @Override
    public void cancelTransaction() {
        throw new IllegalArgumentException("can;t cancel transaction");
    }

    @Override
    public void collectCash(double cash) {
        throw new IllegalArgumentException("can't collect cash as already another transatcion going on");
    }
}
