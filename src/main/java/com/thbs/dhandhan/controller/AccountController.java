package com.thbs.dhandhan.controller;

import com.thbs.dhandhan.controller.request.MiniStatementRequest;
import com.thbs.dhandhan.data.entity.Account;
import com.thbs.dhandhan.data.entity.Customer;
import com.thbs.dhandhan.data.repo.AccountRepo;
import com.thbs.dhandhan.data.service.AccountService;
import com.thbs.dhandhan.data.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepo accountRepo;
    @Autowired
    CustomerService customerService;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable("id") Integer id) {
        return accountService.getAccount(id);
    }


    @PostMapping("/accounts")
    public Integer addAccount(@RequestParam Integer cid) {
        return accountService.createAccount(cid);
    }

    @PostMapping("/accounts/balance")
    public Float getBalances(@RequestBody MiniStatementRequest miniStatementRequest) {
        Integer customerId =  miniStatementRequest.getCustomerId();
        return accountService.getBalance(customerId);
    }

    @PutMapping("/accounts")
    public void updateAccount(@RequestBody Account account) {
        accountRepo.save(account);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable("id") Integer id) {
        accountRepo.deleteById(id);
    }

}





