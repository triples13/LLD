package com.splitwise.model;

import java.util.List;

public class ExactExpense extends Expense{
    public ExactExpense(User paidByUser, List<Split> splits, double totalAmount) {
        super(paidByUser, splits, totalAmount);
    }

    @Override
    public boolean isValidSplit() {
        double amount = 0;
        for(Split split:splits){
            if(!(split instanceof ExactSplit))
                return false;
            amount = amount+split.getAmount();
        }

        if(amount==this.totalAmount)
            return  true;

        return false;
    }
}
