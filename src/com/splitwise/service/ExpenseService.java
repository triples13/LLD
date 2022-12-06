package com.splitwise.service;

import com.splitwise.model.Expense;
import com.splitwise.model.ExpenseType;
import com.splitwise.model.Split;
import com.splitwise.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpenseService {

    List<Expense> expenseList;
    Map<String, Map<String,Double>> expenseMap;
    Map<String, User> userMap;

    ExpenseFactory expenseFactory;

    public ExpenseService(){
        expenseList = new ArrayList<>();
        expenseMap = new HashMap<>();
        userMap = new HashMap<>();
        expenseFactory = new ExpenseFactory();
    }

    public Map<String,User> addUser(User user){
        userMap.put(user.getId(),user);
        expenseMap.put(user.getId(),new HashMap<>());
        return userMap;
    }

    public void addExpense(ExpenseType expenseType,User paidByUser ,List<Split> splits, double totalMoney){
       var expense = expenseFactory.createExpense(expenseType,paidByUser,splits,totalMoney);
       expenseList.add(expense);
       createUserExpenseMap(expense);
    }

    public void createUserExpenseMap(Expense expense){

            var paidByUser = expense.paidByUser;
            var splits =   expense.splits;

            for(Split split: splits){

                var userBalanceSheet = expenseMap.get(paidByUser.getId());
                var paidToUser =  split.getUser().getId();

                if(!userBalanceSheet.containsKey(paidToUser)){
                    userBalanceSheet.put(paidToUser,0.0);
                }

                userBalanceSheet.put(paidToUser,split.getAmount()+userBalanceSheet.get(paidToUser));


                userBalanceSheet = expenseMap.get(paidToUser);

                if(!userBalanceSheet.containsKey(paidByUser.getId()))
                    userBalanceSheet.put(paidByUser.getId(),0.0);

                userBalanceSheet.put(paidByUser.getId(),userBalanceSheet.get(paidByUser.getId())-split.getAmount());
            }
        }

    public void showBalanceSheet(){
        for(Map.Entry<String, Map<String,Double>> entry:expenseMap.entrySet()){

              String userId =  entry.getKey();
              var lendingList = entry.getValue();
              User paidBy = userMap.get(userId);

              for(Map.Entry<String,Double> entry1: lendingList.entrySet()){

                  String paidToUserId  = entry1.getKey();
                  double val = entry1.getValue();
                  User paidToUser = userMap.get(paidToUserId);

                  if(val>0){
                      System.out.println("user:"+paidBy.getName()+" lends:"+Math.abs(val)+" to "+ paidToUser.getName());
                  } else if (val <0){
                      System.out.println("user:"+paidBy.getName()+" owns:"+Math.abs(val)+" to "+ paidToUser.getName());
                  }


              }
        }
    }


}
