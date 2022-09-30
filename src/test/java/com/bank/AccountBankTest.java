package com.bank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AccountBankTest {
    Account account = new Account();

    /*
    User Story 1 : make a deposit in my account
     */
    @Test
    void depositFirstAmount(){
        account.deposit(100);
        Assertions.assertEquals(100, account.getBalance());
    }

    @Test
    void depositMoreThanOnce(){
        account.deposit(100);
        account.deposit(40);
        Assertions.assertEquals(140, account.getBalance());
    }

    /*
    User Story 2 : make a withdrawal from my account
     */
    @Test
    void withdrawalLessThanBalance(){
        account.deposit(100);
        account.withdrawal(30);
        Assertions.assertEquals(70, account.getBalance());
    }

    @Test
    void withdrawalBalance(){
        account.deposit(100);
        account.withdrawal(100);
        Assertions.assertEquals(0, account.getBalance());
    }

    @Test
    void withdrawalMoreThanBalance(){
        account.deposit(100);
        account.withdrawal(300);
        //make sure that the balance doesn't change
        Assertions.assertEquals(100, account.getBalance());

    }

    /*
    User Story 3 : see the history
     */

    @Test
    void showAllHistory(){
        account.deposit(100);
        account.withdrawal(30);
        account.withdrawal(10);
        account.deposit(120);
        account.showHistory();
        Assertions.assertEquals(4,account.getTransactionList().size());
        Assertions.assertEquals(100,account.getTransactionList().get(0).getBalance());
        Assertions.assertEquals(60,account.getTransactionList().get(2).getBalance());
        Assertions.assertEquals(180,account.getBalance());
    }
}
