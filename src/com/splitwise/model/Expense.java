package com.splitwise.model;

import java.util.List;

public abstract class Expense {

    public User paidByUser;
    public List<Split> splits;

    public double totalAmount;

    public Expense(User paidByUser,List<Split> splits,double totalAmount){
        this.paidByUser = paidByUser;
        this.splits = splits;
        this.totalAmount = totalAmount;
    }
    public abstract boolean isValidSplit();
}
