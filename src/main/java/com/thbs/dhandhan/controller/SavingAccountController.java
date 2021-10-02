package com.thbs.dhandhan.controller;


import com.thbs.dhandhan.data.entity.Nominee;
import com.thbs.dhandhan.data.entity.SavingAccount;
import com.thbs.dhandhan.data.repo.SavingAccountRepo;
import com.thbs.dhandhan.data.service.SavingAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SavingAccountController {
    @Autowired
    SavingAccountService savingAccountService;

    @Autowired
    SavingAccountRepo savingAccountRepo;


    @GetMapping("/savingAccounts")
    public List<SavingAccount> getCustomers() {
        return savingAccountService.getAllSavingAccounts();
    }

    @GetMapping("/savingAccounts/{id}")
    public SavingAccount getSavingAccount(@PathVariable("id") Integer id) {
        return savingAccountService.getSavingAccount(id);
    }


    @PostMapping("/savingAccounts")
    public Integer addSavingAccount(@RequestBody SavingAccount savingAccount) {
        return savingAccountService.createSavingAccount(savingAccount);
    }



    @PutMapping("/savingAccounts")
    public void updateSavingAccount(@RequestBody SavingAccount savingAccount) {

        savingAccountRepo.save(savingAccount);
    }
    @DeleteMapping("/savingAccounts/{id}")
    public void deleteSavingAccount(@PathVariable("id") Integer id) {

        savingAccountRepo.deleteById(id);
    }

}

