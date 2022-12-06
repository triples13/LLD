package com.splitwise.test;

import com.splitwise.model.*;
import com.splitwise.service.ExpenseService;

import java.util.*;

public class Driver {

    public static void main(String [] args){

        // input format

        //EXPENSE 1200 u1 4 u1 u2 u3 u4 Exact 0 600 200 400
        //  SHOW

        //EXPENSE 1200 u1 4 u1 u2 u3 u4 Equal
        // SHOW

      //  EXPENSE 1200 u1 4 u1 u2 u3 u4 Percent 20 25 25 30
       // SHOW
        ExpenseService expenseService = new ExpenseService();

        Scanner scanner = new Scanner(System.in);

        User user1 = new User("u1","u1","u1@gmail.com");
        User user2 = new User("u2","u2","u2@gmail.com");
        User user3 = new User("u3","u3","u3@gmail.com");
        User user4 = new User("u4","u4","u4@gmail.com");
        expenseService.addUser(user1);
        expenseService.addUser(user2);
        expenseService.addUser(user3);
        expenseService.addUser(user4);

        Map<String,User> userMap = new HashMap<>();
        userMap.put("u1",user1);
        userMap.put("u2",user2);
        userMap.put("u3",user3);
        userMap.put("u4",user4);


        while (true){
            String command = scanner.nextLine();
            String [] input = command.split(" ");

            String commandType = input[0];

            if(commandType.equals("SHOW")){
                expenseService.showBalanceSheet();
            } else if (commandType.equals("EXPENSE")){

                List<Split> splitList = new ArrayList<>();
                double totalAmount = Double.valueOf(input[1]);
                String paidByUser = input[2];
                String numberOfUser = input[3];

                int totalUser = Integer.valueOf(numberOfUser);
                String [] users = new String[totalUser];
                for(int i=0;i<totalUser;i++){
                   users[i] = input[4+i];
                }

                String  splitType = input[4+totalUser];
                ExpenseType expenseType = ExpenseType.valueOf(splitType);

                if(expenseType.equals(ExpenseType.Equal)){
                    double eachShare = totalAmount/totalUser;
                    for(int j=0;j<totalUser;j++){
                        String userPaid  = users[j];
                        Split split = new EqualSplit(userMap.get(userPaid),eachShare);
                        splitList.add(split);
                    }

                } else if (expenseType.equals(ExpenseType.Exact)){
                    for(int j=1;j<totalUser+1;j++){
                        double share = Double.valueOf(input[4+totalUser+j]);
                        String userPaid  = users[j-1];
                        Split split = new ExactSplit(userMap.get(userPaid),share);
                        splitList.add(split);
                    }
                } else{
                    for(int j=1;j<totalUser+1;j++){
                        double percentShare = Double.valueOf(input[4+totalUser+j]);
                        double share = (percentShare*totalAmount)/100;
                        String userPaid  = users[j-1];
                        Split split = new PercentageSplit(userMap.get(userPaid),share);
                        splitList.add(split);
                    }

                }

                expenseService.addExpense(expenseType,userMap.get(paidByUser),splitList,totalAmount);

            }

        }
    }
}
