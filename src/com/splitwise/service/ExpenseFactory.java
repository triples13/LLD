package com.splitwise.service;

import com.splitwise.model.*;

import java.util.List;

public class ExpenseFactory {

    public Expense createExpense(ExpenseType expenseType, User paidByUser, List<Split> splits, double totalAmount){

           if(expenseType.equals(ExpenseType.Exact))
               return new ExactExpense(paidByUser, splits, totalAmount);
           else if(expenseType.equals(ExpenseType.Equal))
               return new EqualExpense(paidByUser,splits,totalAmount);
           else
               return new PercentExpense(paidByUser,splits,totalAmount);

    }
}
