package com.thbs.dhandhan.controller;

import com.thbs.dhandhan.controller.request.TermedAccountRequest;
import com.thbs.dhandhan.data.entity.TermedAccount;
import com.thbs.dhandhan.data.repo.TermedAccountRepo;
import com.thbs.dhandhan.data.service.TermedAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TermedAccountController {
    @Autowired
    TermedAccountService termedAccountService;

    @Autowired
    TermedAccountRepo termedAccountRepo;

    @GetMapping("/termedAccounts")
    public List<TermedAccount> getCustomers() {
        return termedAccountService.getAllTermedAccounts();
    }

    @GetMapping("/termedAccounts/{id}")
    public TermedAccount getTermedAccount(@PathVariable("id") Integer id) {
        return termedAccountService.getTermedAccount(id);
    }


//    @PostMapping("/termedAccount")
//    public Integer addTermedAccount(@RequestBody TermedAccount termedAccount) {
//        return termedAccountService.createTermedAccount(termedAccount);
//    }

    @PutMapping("/termedAccounts")
    public Integer updateTermedAccount(@RequestBody TermedAccount termedAccount) {
        return termedAccountService.updateTermedAccount(termedAccount);
    }

    @PostMapping("/termedAccounts")
    public Boolean addTermedAccount(@RequestBody TermedAccountRequest termedAccountRequest) {
        return termedAccountService.createTermedAccount(termedAccountRequest);
    }


    @DeleteMapping("/termedAccount/{id}")
    public void deleteTermedAccount(@PathVariable("id") Integer id) {

        termedAccountRepo.deleteById(id);
    }
}