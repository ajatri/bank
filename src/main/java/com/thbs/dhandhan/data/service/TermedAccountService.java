package com.thbs.dhandhan.data.service;

import com.thbs.dhandhan.controller.request.TermedAccountRequest;
import com.thbs.dhandhan.data.entity.Account;
import com.thbs.dhandhan.data.entity.Customer;
import com.thbs.dhandhan.data.entity.TermedAccount;
import com.thbs.dhandhan.data.repo.TermedAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TermedAccountService {
    @Autowired
    private TermedAccountRepo termedAccountRepo;
    @Autowired
    private AccountService accountService;
    @Autowired
    private CustomerService customerService;


    public ArrayList<TermedAccount> getAllTermedAccounts() {
        ArrayList<TermedAccount> termedAccounts = new ArrayList<TermedAccount>();
        termedAccountRepo.findAll().forEach(termedAccounts::add);
        return termedAccounts;
    }

    public TermedAccount getTermedAccount(Integer id) {
        Optional<TermedAccount> termedAccountOptional = termedAccountRepo.findById(id);
        return termedAccountOptional.orElse(null);
    }

    public Integer createTermedAccount(TermedAccount termedAccount) {
        Account insertedTermedAccount = termedAccountRepo.save(termedAccount);
        return insertedTermedAccount.getId();
    }


    public Integer updateTermedAccount(TermedAccount termedAccount) {
        TermedAccount updatedTermedAccount = termedAccountRepo.save(termedAccount);
        return updatedTermedAccount.getId();
    }


    public void deleteTermedAccount(Integer id) {
        termedAccountRepo.deleteById(id);

    }


    public Boolean createTermedAccount(TermedAccountRequest termedAccountRequest) {

//        try {
//            TermedAccount termedAccount = new TermedAccount();
//            Integer accountId = termedAccountRequest.getAccountId();
//            Account account = accountService.getAccount(accountId);
//           Integer customerId = termedAccountRequest.getCustomerId();
//            Customer customer = customerService.getCustomer(customerId);
//            Float amount = termedAccountRequest.getAmount();
//            Integer months = termedAccountRequest.getMonths();
//            Float penalty = amount / 1000;
//           termedAccount.setAccount(account);
//            termedAccount.setAmount(amount);
//            termedAccount.setPenalty(penalty);
//            termedAccount.setMonths(months);
//            termedAccountRepo.save(termedAccount);
//
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//
//
//    }
//
//
       return false;

    }

}