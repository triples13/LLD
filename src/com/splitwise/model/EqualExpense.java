package com.splitwise.model;

import java.util.List;

public class EqualExpense extends Expense{

    public EqualExpense(User paidByUser, List<Split> splits, double totalAmount) {
        super(paidByUser, splits, totalAmount);
    }

    @Override
    public boolean isValidSplit() {

        double amount = 0;
        for(Split split:splits){
            if(!(split instanceof EqualSplit))
                return false;
             amount = amount+split.getAmount();
        }

        if(amount==this.totalAmount)
            return  true;

    return false;
    }
}
