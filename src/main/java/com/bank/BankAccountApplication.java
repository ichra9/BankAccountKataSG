package com.bank;

public class BankAccountApplication {

    public static void main(String[] args){
        Account account = new Account();
        account.deposit(80);
        account.withdrawal(40);
        account.showHistory();
    }
}
