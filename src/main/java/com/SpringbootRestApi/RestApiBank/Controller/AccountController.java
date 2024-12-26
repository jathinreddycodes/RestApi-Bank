package com.SpringbootRestApi.RestApiBank.Controller;

import com.SpringbootRestApi.RestApiBank.Entity.Account;
import com.SpringbootRestApi.RestApiBank.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sbi")

public class AccountController
{
    @Autowired
    AccountService accountService;


    @PostMapping("/create-user")
    public Account createuser(@RequestBody Account account)
    {
        return accountService.addUser(account);
    }

    @GetMapping("/get-balance/{account_number}")
    public Integer getBalnce(@PathVariable Integer account_number)
    {
        return accountService.getbalance(account_number);
    }





    // we can take amount as user input in keyvalue pair using @RequestParam
    //URl : http://localhost:8080/sbi/1/withdraw?amount=50000

    @PostMapping("/{account_number}/withdraw")
    public Integer withdraw(@PathVariable Integer account_number, @RequestParam Integer amount)
    {
        return accountService.withdraw(account_number,amount);
    }


    //we can take both parameter as @Pathvairable
    //URL : http://localhost:8080/sbi/1/withdraw/200

    @PostMapping("/{account_number}/withdraw/{amount}")
    public Integer withdraw1(@PathVariable Integer account_number, @PathVariable Integer amount)
    {
        return accountService.withdraw(account_number,amount);
    }





    @PostMapping("/{acc_number}/deposit/{amount}")
    public Integer deposit(@PathVariable Integer acc_number, @PathVariable Integer amount)
    {
        return accountService.deposit(acc_number,amount);
    }


}
