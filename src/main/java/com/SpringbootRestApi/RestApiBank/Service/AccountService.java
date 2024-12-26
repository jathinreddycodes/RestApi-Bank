package com.SpringbootRestApi.RestApiBank.Service;


import com.SpringbootRestApi.RestApiBank.Entity.Account;
import com.SpringbootRestApi.RestApiBank.serviceRepo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Optional;

@Service
public class AccountService
{
    @Autowired
    AccountRepo accountRepo;

    public Account addUser(Account account)
    {
        return accountRepo.save(account);
    }

    public Integer getbalance(Integer account_number)
    {
        Optional<Account> byId = accountRepo.findById(account_number);
        Account user;
        if(byId.isPresent())
        {
            user = byId.get();
            return user.getBalance();
        }
        else
        {
            System.out.println("User not found");
            return null;
        }
    }

    public Integer withdraw(Integer account_number, Integer amount )
    {
        Optional<Account> byId = accountRepo.findById(account_number);
        Account user;
        if(byId.isPresent())
        {
            user = byId.get();
            int balance = user.getBalance();
            if(balance > amount)
            {
                balance = balance - amount;
                user.setBalance(balance);
                accountRepo.save(user);
                return balance;
            }
            else
            {
                System.out.println("No balance");
                return null;
            }
        }
        else
        {
            return null;
        }
    }

    public Integer deposit(Integer acc_number, Integer amount)
    {
        Optional<Account> byId = accountRepo.findById(acc_number);
        Account user;
        if(byId.isPresent())
        {
            user = byId.get();
            int balance = user.getBalance();
            balance = balance + amount;
            user.setBalance(balance);
            accountRepo.save(user);
            return balance;
        }
        else
        {
            return null;
        }
    }






}
