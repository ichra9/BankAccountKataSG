package com.bank;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Account {
    private double balance;
    private List<Transaction> transactionList;

    public Account(){
        balance = 0;
        transactionList = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance+= amount;
        Transaction transaction = new Transaction("DEPOSIT",new Date(),amount,balance);
        transactionList.add(transaction);
    }

    public void withdrawal(double amount)  {
        if(balance >= amount){
            balance-= amount;
            Transaction transaction = new Transaction("WITHDRAWAL",new Date(),-amount,balance);
            transactionList.add(transaction);
        }
    }
    //US3
    public void showHistory() {
        for(Transaction transaction : transactionList){
            System.out.println("Operation = "+" "+transaction.getOperation()+" "+"Date = "+" "+transaction.getDate()
                    +" "+"Amount = "+" "+transaction.getAmount()+" "+"Balance = "+" "+transaction.getBalance());
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
